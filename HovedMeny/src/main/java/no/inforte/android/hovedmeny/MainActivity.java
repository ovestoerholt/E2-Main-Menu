package no.inforte.android.hovedmeny;

import android.os.Bundle;

public class MainActivity extends AbstractNavDrawerActivity {
        boolean bShowNewButton;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if ( savedInstanceState == null ) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyGoals()).commit();

                bShowNewButton = false;
                invalidateOptionsMenu();
            }
        }

        @Override
        protected NavDrawerActivityConfiguration getNavDrawerConfiguration() {

            /*
            NavDrawerItem[] menu = new NavDrawerItem[] {
                    NavMenuSection.create( 100, "Meg"),
                    NavMenuItem.create(101,"Mine tiltak", "navdrawer_star", false, this),
                    NavMenuItem.create(102, "Mine mål", "navdrawer_heart", true, this),
                    NavMenuSection.create(200, "Konfigurasjon"),
                    NavMenuItem.create(202, "Det som trigger meg", "navdrawer_grin", false, this)};//,
                    //NavMenuItem.create(203, "Eula", "navdrawer_eula", false, this),
                    //NavMenuItem.create(204, "Quit", "navdrawer_quit", false, this)};
            */

            NavDrawerItem[] menu = new NavDrawerItem[] {
                    NavMenuSection.create( 100, "Meg"),
                    NavMenuItem.create(101, getString(R.string.navdrawer_measures), "navdrawer_star", false, this),
                    NavMenuItem.create(102, getString(R.string.nawdrawer_goals), "navdrawer_heart", true, this),
                    NavMenuSection.create(200, getString(R.string.nawdrawer_settings)),
                    NavMenuItem.create(202, getString(R.string.nawdrawer_triggers), "navdrawer_grin", false, this)
            };

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
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyActions()).commit();
                    break;
                case 102:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyGoals()).commit();
                    break;
                case 202:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new FragmentMyTriggers()).commit();
                    break;
            }
        }
}