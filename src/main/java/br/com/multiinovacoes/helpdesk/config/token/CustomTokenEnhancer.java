package br.com.multiinovacoes.helpdesk.config.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import br.com.multiinovacoes.helpdesk.security.UsuarioSistema;

@SuppressWarnings("deprecation")
public class CustomTokenEnhancer implements TokenEnhancer { 
	

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();
		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("nome", usuarioSistema.getUsuario().getNome());
		addInfo.put("id_cliente", usuarioSistema.getUsuario().getCodigoCliente());
		addInfo.put("id_usuario", usuarioSistema.getUsuario().getId());
		//addInfo.put("authorities2", usuarioSistema.getAuthorities());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}

}
