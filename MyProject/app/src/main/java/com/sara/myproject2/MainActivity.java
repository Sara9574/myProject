package com.sara.myproject2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.HashMap;
import java.util.Stack;


public class MainActivity extends AppCompatActivity {


    private HashMap<String, Stack<Fragment>> mStacks;
    public static final String TAB_HOME  = "tab_home";
    public static final String TAB_MENU  = "tab_menu";
    public static final String TAB_SEARCH  = "tab_notifications";
    public static final String TAB_HISTORY = "tab_bot_history";
    public static final String TAB_PROFILE = "tab_profile";
    private String mCurrentTab;
    private TextView toolbarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

        mStacks = new HashMap<String, Stack<Fragment>>();
        mStacks.put(TAB_HOME, new Stack<Fragment>());
        mStacks.put(TAB_MENU, new Stack<Fragment>());
        mStacks.put(TAB_SEARCH, new Stack<Fragment>());
        mStacks.put(TAB_HISTORY, new Stack<Fragment>());
        mStacks.put(TAB_PROFILE, new Stack<Fragment>());

        navigation.setSelectedItemId(R.id.navigation_home);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedTab(TAB_HOME);
                    return true;
                case R.id.navigation_menu:
                    selectedTab(TAB_MENU);
                    return true;
                case R.id.navigation_search:
                    selectedTab(TAB_SEARCH);
                    return true;
                case R.id.navigation_history:
                    selectedTab(TAB_HISTORY);
                    return true;
                case R.id.navigation_profile:
                    selectedTab(TAB_PROFILE);
                    return true;
            }
            return false;
        }
    };

    private void selectedTab(String tabId)
    {
        mCurrentTab = tabId;

        if(mStacks.get(tabId).size() == 0){
            /*
             *    First time this tab is selected. So add first fragment of that tab.
             *    Dont need animation, so that argument is false.
             *    We are adding a new fragment which is not present in stack. So add to stack is true.
             */
            if(tabId.equals(TAB_HOME)){
                pushFragments(tabId, new HomeFragment(),true);

            }else if(tabId.equals(TAB_MENU)){
                pushFragments(tabId, new MenuFragment(),true);

            }else if(tabId.equals(TAB_SEARCH)){
                pushFragments(tabId, new SearchFragment(),true);

            }else if(tabId.equals(TAB_HISTORY)){
                pushFragments(tabId, new HistoryFragment(),true);

            }else if(tabId.equals(TAB_PROFILE)){
                pushFragments(tabId, new ProfileFragment(),true);


            }
    }else {
            /*
             *    We are switching tabs, and target tab is already has atleast one fragment.
             *    No need of animation, no need of stack pushing. Just show the target fragment
             */
            pushFragments(tabId, mStacks.get(tabId).lastElement(),false);
        }
    }

    public void pushFragments(String tag, Fragment fragment, boolean shouldAdd){
        if(shouldAdd)
            mStacks.get(tag).push(fragment);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        //ft.setCustomAnimations(R.anim.enter, R.anim.exit,R.anim.pop_enter,R.anim.pop_exit);
        ft.replace(R.id.fragment_container, fragment).commit();

    }

}



