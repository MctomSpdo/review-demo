package at.htlleonding;

import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import static org.assertj.db.output.Outputs.output;

@QuarkusTest
class MyTest {

    @Inject
    AgroalDataSource ds;

    @Test
    void perssistObject() {


        MyEntityA m = new MyEntityA();
        m.field = "Name";

        long count = MyEntityA.count();

        System.out.println(MyEntityA.listAll());

        Table myEntity = new Table(ds, "MYENTITY");

        output(myEntity).toConsole();

    }

    @Test
    @Transactional
    void cascadePersist() {
        MyEntityA m = new MyEntityA();
        m.field = "Name A";
        m.myEntityB = new MyEntityB();
        m.myEntityB.field = "Name B";

        MyEntityA.persist(m);
        MyEntityA.flush();

        Table myEntityATable = new Table(ds, "A");
        Table myEntityBTable = new Table(ds, "B");

        output(myEntityATable).toConsole();
        output(myEntityBTable).toConsole();





    }

}