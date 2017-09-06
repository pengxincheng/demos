package wangPosDemo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.wangpos.open.api.sdk.client.WpClient;
import com.wangpos.open.api.sdk.client.model.Message;
import com.wangpos.open.api.sdk.client.request.WpRequest;
import com.wangpos.open.api.sdk.client.response.WpResponse;
import com.wangpos.open.api.sdk.internal.util.JsonUtils;
import com.wangpos.wcomp.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: UncleYee
 * Date: 2016/6/7
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
@Component
public class GatewayUtil {
    public static final int REQUEST_OK = 0;
    public static final int REQUEST_FAILED = -1;
    public static final String GATEWAY_URL="http://gw.api.wangpos.com/";
    public static final String vCode="100921";
    public static final String secret="6x2723h68ulom314";

    private static ConcurrentHashMap<String, AccessToken> accessTokenMap = new ConcurrentHashMap<String, AccessToken>();

    /*
    * example
    * ServiceData sd = new ServiceData();
      DBObject param=new BasicDBObject();
      param.put("en",en);
      sd=new GatewayUtil().getServiceDataByApi("coreGetDeviceDetail",param);
    * */

    /**
     * 获取accessToken
     * @return
     * @throws Exception
     */
    public AccessToken getAccessToken() throws Exception {
        AccessToken accessToken = accessTokenMap.get(vCode);
        if(accessToken == null || accessToken.isExpired()) {
            String gateway_get_token_url = GATEWAY_URL +"/api/token?vCode=%s&secret=%s";
            String url = String.format(gateway_get_token_url, vCode,secret);
            String str = HttpUtil.requestGet(url);
            DBObject ret = (DBObject) JSON.parse(str);
            int code = (Integer) ret.get("code");
            if(code == REQUEST_OK) {
                DBObject data = (DBObject) ret.get("data");
                String token = (String) data.get("access_token");
                long expire = (Long) data.get("expire_time");

                accessToken = new AccessToken(token, expire, Integer.parseInt(vCode));
                accessTokenMap.put(vCode, accessToken);
            } else {
                throw new RuntimeException(ret.get("info").toString());
            }
        }

        return accessToken;
    }

    public ServiceData getServiceDataByApi(String apiKey, DBObject params) {
        DBObject dbo=getDataByApi(apiKey,params);
        ServiceData sd=new ServiceData();
        if(dbo!=null){
            sd.status= (Integer) dbo.get("status");
            sd.info= (String) dbo.get("info");
            sd.data=dbo.get("data");
            sd.page=dbo.get("page");
        }else{
            sd.info =(String) dbo.get("info");
        }
        return sd;
    }

    /**
     * 通过API获取接口数据
     * @param apiKey
     * @param params
     * @return
     */
    public DBObject getDataByApi(String apiKey, DBObject params) {
        DBObject ret=new BasicDBObject();
        try {
            if(StringUtils.isNotBlank(vCode)){
                params.put("vCode",Integer.parseInt(vCode));
            }
            int status = REQUEST_OK;
            int callCount = 3;
            do {
                WpClient client = null;
                AccessToken accessToken = getAccessToken();
                params.put("accessToken", accessToken.getAccessToken());
                client = new WpClient(GATEWAY_URL+"api/entry/", accessToken.getAccessToken(), vCode,secret);

                WpRequest request = new WpRequest();
                request.setMethod(apiKey);

                String jsonBody = JsonUtils.bean2Json(params);
                request.setDatas(jsonBody);

                WpResponse response = client.execute(request);

                System.out.println("------------------------------");
                System.out.println(response.getUrl());
                System.out.println("------------------------------");

                callCount--;

                if(null == response){
                    ret=null;
                    System.out.println(response.toString());
                }else{
                    Message result = response.getReceiveResult();
                    if (result != null) {
                        if(result.getData()==null){
                            String info = result.getResult();
                            String json = "{'status':-1,'info':'"+info+"'}";
                            ret=(DBObject) JSON.parse(json);
                        } else{
                            ret=(DBObject) JSON.parse((String) result.getData());
                        }
                    } else {
                        ret=null;
                        System.out.println("empty");
                        System.out.println(response.getMsg());
                    }
                    status = (Integer) result.getCode();
                    if(status != 0) {
                        accessTokenMap.remove(vCode);
                    }
                }


            } while(status !=0 && callCount > 0);

        } catch(Exception e) {
            e.printStackTrace();
            ret = new BasicDBObject("status", REQUEST_FAILED);
            ret.put("info", e.getMessage());
        }

        return ret;
    }

    @Test
    public void testGetData(){
        ServiceData sd = new ServiceData();
        DBObject param=new BasicDBObject();

        param.put("vCode",vCode);
        param.put("vCodeName","yxtc");
        param.put("payModeId","1006");
        param.put("startTime","2016-02-01 14:00:00");
        sd=new GatewayUtil().getServiceDataByApi("facadeExportTransactionsList",param);
        System.out.println(sd);
    }

}
