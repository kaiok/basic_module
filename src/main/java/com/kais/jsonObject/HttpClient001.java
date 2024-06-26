package com.kais.jsonObject;

/**
 * @author kais
 * @date 2022.04.27. 21:14
 */
public class HttpClient001 {

/*    public static void mPostForm(String posturl, List<NameValuePair> params) throws Exception
    {
        //声明一个httppost绑定参数
        HttpPost httppost = new HttpPost(posturl);
        // 绑定到Entity
        httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
        //实例化httpclient对象
        DefaultHttpClient httpclient = new DefaultHttpClient();
        //请求超时
        httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
        //读取超时
        httpclient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,3000);
        //执行请求

        HttpResponse httpResponse =  httpclient.execute(httppost);
        //返回状态为200
        if(httpResponse.getStatusLine().getStatusCode() == 200){
            // 得到应答的字符串，这也是一个 JSON 格式保存的数据
            String res = EntityUtils.toString(httpResponse.getEntity());
            // 应答生成 JSON 对象
            JSONObject result = new JSONObject( res);
            int errcode = result.getInt("errcode");
            //String errmsg = result.getString("errmsg");
            //返回结果
            if(errcode==0){
            }
            else{
            }
        }
    }*/
}