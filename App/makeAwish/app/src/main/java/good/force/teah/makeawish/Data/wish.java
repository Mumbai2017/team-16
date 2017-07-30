package good.force.teah.makeawish.Data;

/**
 * Created by Anurag on 7/30/2017.
 */

public class wish {


    public wish() {
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private int imageResId;

    public wish(int imageResId, String name, String status) {
        this.imageResId = imageResId;
        this.name = name;
        this.status = status;
    }

    private String name,status;
    //private
}
