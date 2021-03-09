package br.com.erudio.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlJackson2HttpMessagemConverter extends AbstractJackson2HttpMessageConverter{

	public YamlJackson2HttpMessagemConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
		// TODO Auto-generated constructor stub
	}
	
	
	

}
