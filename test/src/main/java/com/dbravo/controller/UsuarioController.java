package com.dbravo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbravo.Entity.Usuario;
import com.dbravo.Entity.UsuarioTelefono;
import com.dbravo.model.Mensaje;
import com.dbravo.model.Telefono;
import com.dbravo.model.UsuarioRequest;
import com.dbravo.model.UsuarioResponse;
import com.dbravo.repository.TelefonoRepository;
import com.dbravo.repository.UsuarioRepository;
import com.sun.istack.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	Logger log = Logger.getLogger(UsuarioController.class);
	//private static String SECRET_KEY = "uC7k49z5qqMVJWmX?67FyffDdwuhrdD*B@y6Z9y7B*tpYwW!y9^%S9_cBHVmK_AVkLY*4MDBCW#xEC$6V%-XBUYU2BZ8c2%gB^zyfYy5W-wJbCG2k&D4aSR78=emejXv";
	
	@Autowired
	 private UsuarioRepository proxyUsuario;
	
	@Autowired
	private TelefonoRepository proxyTelefono;
	
	 @GetMapping(path="/Registro",
	consumes= {MediaType.APPLICATION_JSON_VALUE
	  },
	  produces= {
			  MediaType.APPLICATION_JSON_VALUE
	  }) 
	 public ResponseEntity<Mensaje> Registro(
			 @RequestBody UsuarioRequest request) {
		 
		 log.info("ingresando a método");
		 ResponseEntity<Mensaje> ret;
		Mensaje msj = new Mensaje();
		msj.setMensaje("OK");
		 ret= new ResponseEntity<Mensaje>(msj,HttpStatus.OK);
		 log.info("Validando email");
		 //Validaciones: Mail, password
		 Pattern patternMail = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		 Matcher matcherMail = patternMail.matcher(request.getEmail().trim());
		 
	        if (!matcherMail.find()) {
	            msj.setMensaje("El email ingresado es inválido.");
	            return ret;
	        }
			 log.info("Validando password");
	        Pattern patternPass = Pattern
		                .compile("^(?=\\w*\\d{2,})(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,}$");
			 Matcher matcherPass = patternPass.matcher(request.getPassword().trim());
			 
		        if (!matcherPass.find()) {
		            msj.setMensaje("La contraseña no es válida ( Al menos 1 letra mayúscula, una minúscula y dos números");
		            return ret;
		        }
		 
		 Usuario usuario = new Usuario();
		 usuario.setEmail(request.getEmail().trim());
		 usuario.setName(request.getName());
		 usuario.setPassword(request.getPassword());
		 Date fechaHoy= new Date();
		 usuario.setCreated(fechaHoy);
		 usuario.setLast_login(fechaHoy);
		 usuario.setModified(fechaHoy);
		 usuario.setIsactive(true);
		 String token = UUID.randomUUID().toString();//createJWT(usuario.getId(),usuario.getEmail(),"Login",600);
		 usuario.setToken(token);
		 
		 //Si existe mail, actualizamos el registro y modificamos el mensaje de salida
		 Optional<Usuario> usuExiste=proxyUsuario.findByEmail(request.getEmail());
		 log.info("Verificando si existe usuario");
		 if(usuExiste.isPresent()) {
			 usuario.setId(usuExiste.get().getId());
			 usuario.setCreated(usuExiste.get().getCreated());
			 msj.setMensaje("El correo ya registrado");
		 }
		 
		
	
		 List<UsuarioTelefono> telefonos = new ArrayList<UsuarioTelefono>();
		 for(Telefono nodo : request.getPhones()) {
			 UsuarioTelefono telefono =  new UsuarioTelefono();
			 telefono.setCitycode(nodo.getCitycode());
			 telefono.setContrycode(nodo.getContrycode());
			 telefono.setNumber(nodo.getNumber());
			 telefono.setUsuario(usuario);
			 telefonos.add(telefono);
		 }
		 log.info("guardando usuario");
		 proxyUsuario.save(usuario);
		 proxyTelefono.saveAll(telefonos);
		 msj.setUsuario(new UsuarioResponse(usuario));
		 return ret;
	 }

	/* private static String createJWT(String id, String issuer, String subject, long ttlMillis) {

	        
	        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

	        long nowMillis = System.currentTimeMillis();
	        Date now = new Date(nowMillis);

	        
	        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
	        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

	        
	        JwtBuilder builder = Jwts.builder().setId(id)
	                .setIssuedAt(now)
	                .setSubject(subject)
	                .setIssuer(issuer)
	                .signWith(signatureAlgorithm, signingKey);

	       
	        if (ttlMillis >= 0) {
	            long expMillis = nowMillis + ttlMillis;
	            Date exp = new Date(expMillis);
	            builder.setExpiration(exp);
	        }

	        
	        return builder.compact();
	    }*/
}
