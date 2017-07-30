package good.force.teah.makeawish.Data;

/**
 * Created by Anurag on 7/30/2017.
 */

public class wish {
    private String name,status;
    private int imageResId;

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

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public wish() {
    }

    public  wish (String name, String status){
        this.name = name;
        this.status = status;
    }
    public wish(String name, String status, int imageResId) {

        this.name = name;
        this.status = status;
        this.imageResId = imageResId;
    }
    //private
}
