"""import requests
url="http://localhost:9999/ws/hello?wsdl"
#headers = {'content-type': 'application/soap+xml'}
headers = {'content-type': 'text/xml'}
body = <?xml version="1.0" encoding="UTF-8"?>
         <SOAP-ENV:Envelope xmlns:ns0="http://jlb.org/webservice/" xmlns:ns1="http://schemas.xmlsoap.org/soap/envelope/" 
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
            <SOAP-ENV:Header/>
              <ns1:Body><ns0:setOption/></ns1:Body>
         </SOAP-ENV:Envelope>

response = requests.post(url,data=body,headers=headers)
print response.content"""

import zeep

wsdl = 'http://localhost:9999/ws/hello?wsdl'
client = zeep.Client(wsdl=wsdl)
print(client.service.getHelloWorldAsString("Jubert"))