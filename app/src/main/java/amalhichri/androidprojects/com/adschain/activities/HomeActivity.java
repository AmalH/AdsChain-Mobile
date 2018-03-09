package amalhichri.androidprojects.com.adschain.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import amalhichri.androidprojects.com.adschain.R;
import amalhichri.androidprojects.com.adschain.adapters.HomePageTabsAdapter;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class HomeActivity extends AppCompatActivity {


    private static TabLayout tablayout;
    private static ViewPager vpPager;
    private HomePageTabsAdapter adapter;
    private static ColorMatrixColorFilter filter;
    private ColorMatrix matrix;
    private FragmentManager fragmentManager;
    private PendingIntent pendingIntent;
    private AlarmManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentManager =getSupportFragmentManager();

        //Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        //pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);


        /*if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, PERMISSION_REQUEST_CODE);
            }else {
                /*if(((TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE)).getNetworkOperatorName().equals("Orange Tn"))
                {
                    // if user has sms
                    JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(JOB_SCHEDULER_SERVICE);
                    ComponentName componentName = new ComponentName(getApplicationContext(), SMSService.class);
                    JobInfo jobInfo = new JobInfo.Builder(1, componentName).setPeriodic(5000).build(); // setPeriodic(10000)
                    jobScheduler.schedule(jobInfo);
                }
                else{
                    Toast.makeText(getApplicationContext(), "You have no free SMS plans !", Toast.LENGTH_LONG).show();
                }
            }
        }*/

        /** will be used to change tab icons colors on select/deselect */
        matrix = new ColorMatrix();
        matrix.setSaturation(0);
        filter = new ColorMatrixColorFilter(matrix);

        /** setting the actionBar **/
        getSupportActionBar().hide();

        /*** setting the tabsLayout ***/
        adapter = new HomePageTabsAdapter(getSupportFragmentManager());
        vpPager = findViewById(R.id.viewpager);
        vpPager.setAdapter(adapter);
        vpPager.setCurrentItem(0);
        vpPager.setOffscreenPageLimit(2);
        tablayout=findViewById(R.id.tabsLayout);
        tablayout.setupWithViewPager(vpPager);
        setUpTabIcons(tablayout);


        /** change title in actionBar depending on tabSelected **/
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch(tablayout.getSelectedTabPosition()) {
                    case 0:
                        tab.getIcon().clearColorFilter();
                        break;
                    case 1:
                        tab.getIcon().clearColorFilter();
                        break;
                    case 2:
                        tab.getIcon().clearColorFilter();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(filter);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }





    /*** helper methods ***/
    private static void allTabIconsToDeselected(TabLayout tablayout){
        for(int i=1;i<3;i++){
            tablayout.getTabAt(i).getIcon().setColorFilter(filter);
        }
    }
    private static void setUpTabIcons(TabLayout tbs){
        tbs.getTabAt(0).setIcon(R.drawable.ic_wallet_tab2);
        tbs.getTabAt(1).setIcon(R.drawable.ic_configurations_tab1);
        tbs.getTabAt(2).setIcon(R.drawable.ic_others);
        allTabIconsToDeselected(tbs);
    }
    /** to prevent back to loginActivity **/
    @Override
    public void onBackPressed() {
           fragmentManager.popBackStack();
    }

    /** for calligraphy lib usage **/
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}