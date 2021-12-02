package io.github.stevewjin.gtm.cli.service.impl;

import com.beust.jcommander.JCommander;
import io.gate.gateapi.ApiClient;
import io.gate.gateapi.api.SpotApi;
import io.gate.gateapi.models.SpotAccount;
import io.github.stevewjin.gtm.cli.common.constant.GtmCliConstant;
import io.github.stevewjin.gtm.cli.common.utils.StringUtils;
import io.github.stevewjin.gtm.cli.options.ClientOptions;
import io.github.stevewjin.gtm.cli.service.ExchangeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @author Steve Jin
 * @version 1.0.0
 * @description
 * @date 2021-12-02 18:29
 */
public class GateIOExchangeServiceImpl implements ExchangeService {

    private ClientOptions clientOptions;

    private JCommander jCommander;

    public GateIOExchangeServiceImpl(ClientOptions clientOptions, JCommander jCommander) {
        this.clientOptions = clientOptions;
        this.jCommander = jCommander;
    }

    @Override
    public void command() {
        ApiClient client = new ApiClient();
        client.setApiKeySecret(clientOptions.getApiKey(), clientOptions.getSecretKey());
        client.setBasePath(GtmCliConstant.GATE_IO_API_URL);
        SpotApi spotApi = new SpotApi(client);
        try {
            List<SpotAccount> accounts = spotApi.listSpotAccounts().currency(GtmCliConstant.USDT).execute();
            assert accounts.size() == 1;
            BigDecimal available = new BigDecimal(Objects.requireNonNull(accounts.get(0).getAvailable()));
            jCommander.getConsole().println("Your usdt: " + available.toPlainString());
        } catch (Exception e) {
            jCommander.getConsole().println("Error: " + e.getMessage());
            return;
        }
    }

}
