# testspringboot
 
<h2>Tecnología: </h2>
<ul><li>Java Enterprise</li>
  <li>Spring boot 2.2</li></ul>
  <h2>Prerequisitos</h2>
    <ul><li>java jdk 1.8</li>
  <li>git</li>
  </ul>

<h2>invocación</h2>
<b>/Registro</b>
<code>
curl --location --request GET 'http://localhost:8080/api/v1/Registro' \
--header 'Content-Type: application/json' \
--data-raw '{
"name" : "Juan Rodriguez g" ,
"email" : "juan@rodriguez.com" ,
"password" : "Hunter22" ,
"phones" : [
{
"number" : "1234567" ,
"citycode" : "1" ,
"contrycode" : "57"
}
,
{
"number" : "12345678" ,
"citycode" : "1" ,
"contrycode" : "56"
}
]
}'</code>
