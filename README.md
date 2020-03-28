# accounting

spring boot整合mybatis-plus需要注意事项

1. 配置mybatis-plus.mapper-locations
2.在pom中引入配置：
        <resources>
            <!--引入静态文件-->
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>
