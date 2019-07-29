package strathcafe.strathcafe.com;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import strathcafe.strathcafe.com.fragments.Discount;
import strathcafe.strathcafe.com.fragments.main_menu;
import strathcafe.strathcafe.com.fragments.veges_option;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch(position)
        {

            case 0:
                main_menu tab1 = new main_menu();
                return tab1;
            case 1:
                veges_option tab2 = new veges_option();
                return  tab2;
            case 2:
                Discount tab3 = new Discount();
                return  tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
