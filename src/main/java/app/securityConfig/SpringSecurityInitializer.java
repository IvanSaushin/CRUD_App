package app.securityConfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    //
    /*
    пустой класс, использующийся для регистрации модуля в спринг-контейнере

    //обеспечит springSecurityFilterChain регистрацию
     или -
     просто зарегистрирует фильтр springSecurityFilterChain только для каждого URL-адреса в вашем приложении


    Если бы мы использовали Spring где-то еще в нашем приложении, у нас, вероятно,
     уже был бы WebApplicationInitializerзагружающий нашу конфигурацию Spring.
     Если мы воспользуемся предыдущей конфигурацией, мы получим ошибку. Вместо
     этого мы должны зарегистрировать Spring Security с существующим ApplicationContext.
      Например, если бы мы использовали Spring MVC, наш
      SecurityWebApplicationInitializerбы выглядел примерно так, как в этом классе.
     */
}
