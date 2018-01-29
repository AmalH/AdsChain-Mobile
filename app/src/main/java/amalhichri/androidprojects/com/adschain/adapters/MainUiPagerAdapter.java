package amalhichri.androidprojects.com.adschain.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import amalhichri.androidprojects.com.adschain.R;


/**
 * Created by Amal on 29/11/2017.
 */

public class MainUiPagerAdapter extends PagerAdapter {


    private int mSize;
    private Context context;
    private int[] icons = new int[]{R.drawable.learn,R.drawable.code,R.drawable.compete,R.drawable.discuss};
    private String[] textViewContents1 = new String[]{"Welcome to ChainIt","Call","Earn","Earn more"};
    private String[] textViewContents2 = new String[]{"Connect and earn at once",
    "Free calls and messages \n to any ChainIt user in the world ",
    "Trade your free SMS to AFRIcoins","Trade more. Get more AFRIcoins"};

    public MainUiPagerAdapter(Context context) {
        this.context=context;
        mSize = 4;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object) {
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View v= ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.mainui_viewpager_item, view, false);
     //   ((ImageView)v.findViewById(R.id.main_ui_image)).setImageResource(icons[position]);
        ((TextView)v.findViewById(R.id.main_ui_text1)).setText(textViewContents1[position]);
        ((TextView)v.findViewById(R.id.main_ui_text1)).setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/graublau_slab_bold.ttf"));
        ((TextView)v.findViewById(R.id.main_ui_text2)).setText(textViewContents2[position]);
        ((TextView)v.findViewById(R.id.main_ui_text2)).setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/graublau_slab.ttf"));
         view.addView(v);
       return v;
    }
}