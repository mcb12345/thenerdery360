package com.springapp.mvc.config;

/**
 * Created by MCB on 10/18/2014.
 */
//@org.springframework.context.annotation.Configuration //Marks this class as configuration
////Specifies which package to scan
//@ComponentScan("com.springapp.mvc")
////Enables Spring's annotations
//@EnableWebMvc
//@EnableTransactionManagement
//public class Config extends WebMvcConfigurerAdapter {
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/js/**")
//                .addResourceLocations("/js/");
//        //super.addResourceHandlers(registry);
//    }
//
//    @Bean
//    public UrlBasedViewResolver setupViewResolver() {
//        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);
//        return resolver;
//    }
//
//    @Bean(name = "gameDao")
//    public GameDao gameDao() {
//        return new GameDao();
//    }
//
//    @Bean(name = "gamesService")
//    public GamesService gamesService() {
//        return new GamesService();
//    }
//
//    @Bean(name = "hibernateTemplate")
//    public HibernateTemplate getHibernateTemplate() {
//        return new HibernateTemplate(getSessionFactory());
//    }
//
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory() {
//
//        //File file = new File("C:\\projects\\thenerdery360\\src\\main\\java\\com\\springapp\\mvc\\config\\hibernate.cfg.xml");
//        //File file = new File("hibernate.cfg.xml");
//        Configuration cfg = new Configuration().configure();
//        //cfg.addR
//        cfg.addResource("/Game.hbm.xml").addResource("/Vote.hbm.xml");
//        ServiceRegistry srb = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
//        return cfg.buildSessionFactory(srb);
//    }
//
//    @Bean
//    public HibernateTransactionManager hibernateTransactionManager() {
//        return new HibernateTransactionManager(getSessionFactory());
//    }
//}
