package com.grammyweb;

import com.grammyejb.business.RewardServiceEjb;
import com.grammyejb.business.SingleServiceEjb;
import com.grammyejb.business.external.MusicBandService;
import com.grammyejb.business.mappers.RewardMapper;
import com.grammyejb.business.mappers.SingleMapper;
import com.grammyejb.config.properties.MusicBandsServiceProps;
import com.grammyejb.repositories.RewardRepositoryEjb;
import com.grammyejb.repositories.SingleRepositoryEjb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({RewardServiceEjb.class, SingleServiceEjb.class, RewardMapper.class, SingleMapper.class, MusicBandService.class, MusicBandsServiceProps.class, RewardRepositoryEjb.class, SingleRepositoryEjb.class})
public class BandGrammyWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BandGrammyWebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BandGrammyWebApplication.class, args);
	}
}