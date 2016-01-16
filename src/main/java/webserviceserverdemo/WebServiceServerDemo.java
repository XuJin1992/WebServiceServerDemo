package webserviceserverdemo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @功能: WebService Server
 * @authord: jin.xu
 * @version: v1.0.0
 * @see:
 * @date: 2016/1/16 16:10
 */
@WebService(serviceName="WebServiceServerDemo")
public class WebServiceServerDemo {

    /**operationName指定操作的方法别名，可以省略，默认是方法名*/
    @WebMethod(operationName="welcome")
    /**指定返回的localPart*/
    @WebResult(name="welcomereturn")
    public String welcome(@WebParam(name="name") String name){
        String retValue="Hello WebService : " + name;
        return retValue;
    }

    public String goodbye(String name){
        String retValue= "goodbye WebService : " + name;
        return retValue;
    }

    /**exclude=true表明该方法不被发布*/
    @WebMethod(exclude=true)
    public String welcomeExclude(String name){
        String retValue= "Hello WebService[exclude] : " + name;
        return retValue;
    }

    public static void main(String[] args) {

        /**
         * 参数1：url，指服务的发布地址
         * 参数2：wenservice服务类，编写具体的服务逻辑代码
         */
        Endpoint.publish("http://localhost:9010/xiaofengcanyu.indv.com", new WebServiceServerDemo());
    }

}