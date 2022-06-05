package User;

import sun.awt.geom.AreaOp;
import Operation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 86176
 * Date: 2022-06-05
 * Time: 16:56
 */
public class Administrator extends User{
    public Administrator(String name) {
        super(name);

    }

    @Override
    public int menu() {
        return 0;
    }
}
