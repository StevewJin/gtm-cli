# gtm-cli
## 项目介绍
我们开发的GTM自动交易机器人APP（ http://www.gtmswap.xyz ）在推广时发现，
还是有很多朋友不愿意将交易所API的ApiKey和SecretKey授权给App存储在我们的伺服器，
当然，关于ApiKey和SecretKey我们会加密妥善存储。
但是就算我们承诺如此，因为我们不是大厂，也没有什么大厂为我们背书，只是想回馈加密社区的小团队开发的APP，大家不信任也合情合理。

所以现在，我们决定开源GTM自动交易机器人APP的核心代码，并开发出cli（command-line interface）供大家在自己的电脑上跑自动化交易的任务，让大家安全、让大家放心。

## 如何使用
因项目正在开发中，目前只能下载源码编译运行。项目正式可使用后，我们将发布可执行的一键脚本，敬请期待！

如果你有能力，希望你也能参与开发贡献，让我们把财富变得更简单。
```shell
git clone https://github.com/StevewJin/gtm-cli.git
cd gtm-cli
mvn package gtm-cli
cd target
java -jar gtm-cli-0.0.1.jar -exchange GateIO -apiKey xxx -secretKey xxx
```

## 执行参数描述
| 参数 | 描述 |
| :----: | :----: |
| --version | 查看当前版本 |
| --help | 获取帮助 |
| -exchange | 选择交易所，如：-exchange GateIO（目前只支持GateIO）、-exchange Binance |
| -apiKey | 输入ApiKey，如：-apiKey xxxxxx |
| -secretKey | 输入SecretKey，如：-secretKey xxxxxx |

## 开发日志
2021-12-02：已支持-exchange -apiKey -secretKey，查询当前交易所USDT余额