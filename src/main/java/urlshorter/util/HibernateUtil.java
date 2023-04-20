package urlshorter.util;

import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.hibernate.type.SqlTypes;
import urlshorter.link.Link;


import java.util.EnumSet;

@UtilityClass
public class HibernateUtil {




    public static SessionFactory buildSessionFactory() {
        Configuration configuration = buildConfiguration();
        configuration.configure();

        EnumSet<TargetType> database = EnumSet.of(TargetType.DATABASE);

        // Build the metadata from the configuration
        MetadataSources metadataSources = new MetadataSources(new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build());
        metadataSources.addAnnotatedClass(Link.class);
//        metadataSources.addAnnotatedClass(Planet.class);
//        metadataSources.addAnnotatedClass(Ticket.class);
        metadataSources.addAnnotatedClass(SqlTypes.class);

        // Set the metadata in the SchemaExport object
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.execute(database, SchemaExport.Action.CREATE, metadataSources.buildMetadata());

        return configuration.buildSessionFactory();
    }

    public static Configuration buildConfiguration() {
        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(Client.class);
//        configuration.addAnnotatedClass(Planet.class);
//        configuration.addAnnotatedClass(Ticket.class);
        configuration.addAnnotatedClass(SqlTypes.class);
        return configuration;
    }


    public static void main(String[] args) {

    }
}
