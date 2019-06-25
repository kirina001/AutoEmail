package com.testing.interTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axiom.mime.Header;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.NamedValue;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties.ProxyProperties;

import com.testing.inter.HttpClientKw;

public class TestSoapInterWithHttpClient
{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HttpClientKw kw=new HttpClientKw();
		String em="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://soap.testingedu.com/\"><soapenv:Header/><soapenv:Body><soap:auth></soap:auth></soapenv:Body></soapenv:Envelope>";
		kw.doSoap("http://www.testingedu.com.cn/inter/SOAP?wsdl", em);
	}
}
