![](https://aliyunsdk-pages.alicdn.com/icons/AlibabaCloud.svg)

# YuanJing OpenAPI SDK for Go

## Requirements
- It's necessary for you to make sure your system have installed Go environment which version greater than 1.15.0.

## Installation
If you use `go mod` to manage your dependence, you can use the following command:
```
go get github.com/aliyun/alibabacloud-yjopenapi-go-client 1.0.20230531.pre-SNAPSHOT
```

## Usage
```
import (
    "github.com/aliyun/alibabacloud-yjopenapi-go-client/client/api"
    "github.com/aliyun/alibabacloud-yjopenapi-go-client/client/model"
)

configuration := api.DefaultConfiguration
configuration.Host = "host"
configuration.AccessKey = "Your Access Key"
configuration.SecretKey = "Your Secret Key"

client := api.NewAPIClient(configuration)

// {{Api}},{{Method}},{{Param}} is placeholder, take a look at Explain Of Usage Placeholder
result, response, error := client.{{Api}}.{{Method}}(&model.{{Params}}{})

// OpenAPI TraceId
traceId := response.Header.Get(client.Trace_Id)
// OpenAPI Status Code
statusCode := response.Header.Get(client.Result_Status)

// OpenAPI result
_ := result
```

## Explain Of Usage Placeholder

| Api | Method | Params | Result | Description |
| ------------ | ------------- | ------------- | ------------- | ------------- |
 | *ConsoleAdminApi* | **AddGameToProjectt** | *AddGameToProjecttForms*  | *ConsoleAdminAddGameToProjecttResult* | 游戏添加项目 |
 | *ConsoleAdminApi* | **CreateGame** | *CreateGameForms*  | *ConsoleAdminCreateGameResult* | 创建游戏 |
 | *ConsoleAdminApi* | **GetGameVersionProgresss** | *GetGameVersionProgresssForms*  | *ConsoleAdminGetGameVersionProgresssResult* | 查询版本处理进度（上传、适配评测、部署） |
 | *ConsoleAdminApi* | **ListGamessss** | *ListGamessssForms*  | *ConsoleAdminListGamessssResult* | 列表 |
 | *ConsoleAdminApi* | **ListInstancesOfProject** | *ListInstancesOfProjectForms*  | *ConsoleAdminListInstancesOfProjectResult* | 分页获取项目中的实例 |
 | *ConsoleAdminApi* | **StopGamee** | *StopGameeForms*  | *ConsoleAdminStopGameeResult* | 停止游戏 |
 | *TokenApi* | **GetPair** |   | *GetPairResult* | 获取临时安全令牌(二元组) |
 | *TokenApi* | **GetTriple** |   | *GetTripleResult* | 获取临时安全令牌 |

## License
[Apache-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Copyright (c) 2009-present, Alibaba Cloud All rights reserved.


