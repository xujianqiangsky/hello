<p style="text-align:center">
    <img src="https://jqm.plus/logo.svg" height="120" alt="jqm"/>
</p>
<p style="text-align:center">
    <img src="https://img.shields.io/badge/hello-1.0-success.svg" alt="hello 1.0"/>
    <img src="https://img.shields.io/badge/Spring%20Cloud-2023-blue.svg" alt="Spring Cloud 2023"/>
    <img src="https://img.shields.io/badge/Spring%20Boot-3.2-blue.svg" alt="Spring Boot 3.2"/>
    <img src="https://img.shields.io/badge/Sa--Token-1.37.0-blue.svg" alt="Sa-Token 1.37.0"/>
    <img src="https://img.shields.io/github/license/xujianqiangsky/hello" alt="MIT license"/>
</p>

---

## 项目介绍
基于 Spring Cloud 、Spring Boot、 Sa-Token 的微服务通用权限管理系统

### 核心依赖
| 依赖                   | 版本         |
|----------------------|------------|
| Spring Boot          | 3.2.5      |
| Spring Cloud         | 2023.0.1   |
| Spring Cloud Alibaba | 2022.0.0.0 |
| Sa-Token             | 1.37.0     |
| Mybatis Plus         | 3.5.6      |

### 模块说明

```lua
hello
├── hello-auth -- 身份认证服务模块
└── hello-common -- 系统公共模块
     ├── hello-common-api -- 公共接口
     ├── hello-common-core -- 公共配置类核心包
     ├── hello-common-http-service -- restClient 扩展封装
     ├── hello-common-sa-token -- 公共权限配置
├── hello-gateway -- 网关模块
└── hello-system -- 通用权限管理业务模块
```