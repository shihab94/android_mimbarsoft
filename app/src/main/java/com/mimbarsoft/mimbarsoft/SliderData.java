package com.mimbarsoft.mimbarsoft;

/*
*  This is the class which will provide data
* */

import java.util.ArrayList;
import java.util.List;

public class SliderData {
    private static String[] titles = {"POS Software","Android App For Doctor","Ecommerce Site"};
    private static int[] imageId = {R.drawable.cappuccino,R.drawable.mimbarsoft_banner,
            R.raw.mimbarsoft_logo};

    public static List<SliderBean> getData(){
        List<SliderBean> data = new ArrayList<>();
        for(int i = 0; i<3; i++){
            SliderBean item = new SliderBean();
            item.setTitle(titles[i]);
            item.setImageID(imageId[i]);
            data.add(item);
        }
        return data;
    }
}
