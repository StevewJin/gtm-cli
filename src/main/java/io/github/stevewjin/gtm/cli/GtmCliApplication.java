package io.github.stevewjin.gtm.cli;

import com.beust.jcommander.JCommander;
import io.github.stevewjin.gtm.cli.common.constant.GtmCliConstant;
import io.github.stevewjin.gtm.cli.common.utils.StringUtils;
import io.github.stevewjin.gtm.cli.options.ClientOptions;
import io.github.stevewjin.gtm.cli.service.ExchangeService;
import io.github.stevewjin.gtm.cli.service.impl.GateIOExchangeServiceImpl;

/**
 * @author Steve Jin
 * @version 1.0.0
 * @description
 * @date 2021-12-02 16:41
 */
public class GtmCliApplication {

    public static void main(String[] args) {
        ClientOptions co = new ClientOptions();
        JCommander jCommander = JCommander.newBuilder()
                .addObject(co)
                .build();

        try {
            jCommander.parse(args);
        } catch (Exception e) {
            jCommander.getConsole().println(e.getMessage());
            jCommander.getConsole().println("try --help for help.");
            return;
        }

        if (co.isHelp()) {
            jCommander.usage();
            return;
        } else if (co.isVersion()) {
            jCommander.getConsole().println("GTM-CLI for coin auto exchange.");
            jCommander.getConsole().println("Version: 0.0.1");
            return;
        }

        if (StringUtils.isEmpty(co.getExchange()) || StringUtils.isEmpty(co.getApiKey()) || StringUtils.isEmpty(co.getSecretKey())) {
            jCommander.getConsole().println("Exchange/ApiKey/SecretKey can not be null.");
            return;
        }

        if (co.getExchange().equals(GtmCliConstant.GATE_IO)) {
            ExchangeService exchangeService = new GateIOExchangeServiceImpl(co, jCommander);
            exchangeService.command();
            return;
        } else if (co.getExchange().equals(GtmCliConstant.BINANCE)) {
            // TODO Binance
        }

        jCommander.getConsole().println("try --help for help.");

    }

}
