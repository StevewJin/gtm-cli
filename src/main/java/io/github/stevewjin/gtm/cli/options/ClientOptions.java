package io.github.stevewjin.gtm.cli.options;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

/**
 * @author Steve Jin
 * @version 1.0.0
 * @description
 * @date 2021-12-02 16:42
 */
@Parameters(separators = "=", commandDescription = "GTM-CLI for coin auto exchange.")
public class ClientOptions {

    @Parameter(names = {"--level", "--l"})
    private Integer level = 1;

    @Parameter(names = "--help", help = true)
    private boolean help;

    @Parameter(names = "--version", description = "GTM-CLI Version")
    private boolean version;

    @Parameter(names = "-exchange", description = "Example: GateIO/Binance", required = true)
    private String exchange;

    @Parameter(names = "-apiKey", required = true)
    private String apiKey;

    @Parameter(names = "-secretKey", required = true)
    private String secretKey;

    @Parameter(names = "-coin")
    private String coin;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public boolean isVersion() {
        return version;
    }

    public void setVersion(boolean version) {
        this.version = version;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }
}
