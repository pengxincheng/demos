package wangPosDemo;

import org.bson.types.ObjectId;

/**
 * Created with IntelliJ IDEA.
 * User: UncleYee
 * Date: 2016/5/19
 * Time: 9:38
 * To change this template use File | Settings | File Templates.
 */
public class AccessToken {
    public static final long ACCESS_TOKEN_EXPIRE = 4 * 60 * 60 * 1000;
    private ObjectId _id;
    private Integer vCode;
    private long expireTime;
    private String createTime;
    private String token; //ֵ
    public AccessToken(){

    }
    public AccessToken(String accessToken, long expireTime, Integer vCode) {
        this.token = accessToken;
        this.expireTime = expireTime;
        this.vCode = vCode;
    }

    public String getAccessToken() {
        return token;
    }

    public boolean isExpired() {
        if(token == null) {
            return true;
        }

        long currentTime = System.currentTimeMillis();
        return currentTime > expireTime;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getvCode() {
        return vCode;
    }

    public void setvCode(Integer vCode) {
        this.vCode = vCode;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
