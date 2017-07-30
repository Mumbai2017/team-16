package good.force.teah.makeawish.Data;

import java.util.ArrayList;
import java.util.List;

public class WishData {
    private static final String[] names={"swarali","akshu","gauri"};
    private static final String[] status={"pending","approved","granted"};
    private static final int[] icons={android.R.drawable.ic_popup_reminder,android.R.drawable.ic_menu_edit,android.R.drawable.ic_menu_delete};




    public static List<wish> getListData()
    {
        List<wish> data=new ArrayList<>();
        for(int x=0;x<4;x++)
        {
            for(int i=0;i<names.length&& i<icons.length;i++)
            {
                wish item=new wish();
                item.setImageResId(icons[i]);
                item.setName(names[i]);
                item.setStatus(status[i]);
                data.add(item);
            }
        }
        return data;
    }
}
