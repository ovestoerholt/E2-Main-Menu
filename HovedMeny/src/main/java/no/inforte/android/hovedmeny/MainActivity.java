package no.inforte.android.hovedmeny;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AbstractNavDrawerActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if ( savedInstanceState == null ) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyStatus()).commit();
            }
        }

        @Override
        protected NavDrawerActivityConfiguration getNavDrawerConfiguration() {

            NavDrawerItem[] menu = new NavDrawerItem[] {
                    NavMenuSection.create( 100, "Meg"),
                    NavMenuItem.create(101,"Status", "navdrawer_star", false, this),
                    NavMenuItem.create(102, "Mine mål", "navdrawer_heart", true, this),
                    NavMenuSection.create(200, "Konfigurasjon"),
                    NavMenuItem.create(202, "Det som trigger meg", "navdrawer_grin", false, this)};//,
                    //NavMenuItem.create(203, "Eula", "navdrawer_eula", false, this),
                    //NavMenuItem.create(204, "Quit", "navdrawer_quit", false, this)};

            NavDrawerActivityConfiguration navDrawerActivityConfiguration = new NavDrawerActivityConfiguration();
            navDrawerActivityConfiguration.setMainLayout(R.layout.activity_main);
            navDrawerActivityConfiguration.setDrawerLayoutId(R.id.drawer_layout);
            navDrawerActivityConfiguration.setLeftDrawerId(R.id.left_drawer);
            navDrawerActivityConfiguration.setNavItems(menu);
            navDrawerActivityConfiguration.setDrawerShadow(R.drawable.drawer_shadow);
            navDrawerActivityConfiguration.setDrawerOpenDesc(R.string.drawer_open);
            navDrawerActivityConfiguration.setDrawerCloseDesc(R.string.drawer_close);
            navDrawerActivityConfiguration.setBaseAdapter(
                    new NavDrawerAdapter(this, R.layout.navdrawer_item, menu ));
            return navDrawerActivityConfiguration;
        }

        @Override
        protected void onNavItemSelected(int id) {
            switch ((int)id) {
                case 101:
                    Context context = getApplicationContext();
                    CharSequence text = "Hello toast!";
                    int duration = Toast.LENGTH_SHORT;

                    //Toast toast = Toast.makeText(context, text, duration);
                    //toast.show();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyStatus()).commit();
                    break;
                case 102:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyGoals()).commit();
                    break;
                case 202:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyTriggers()).commit();

                    /*
                    FragmentManager fragmentManager = getFragmentManager();
                            //getSupportFragmentManager();

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    FragmentMyTriggers fragment = new FragmentMyTriggers();
                    fragmentTransaction.replace(R.id.content_frame, fragment);
                    fragmentTransaction.commit();
                    */

                    break;
            }
        }
}