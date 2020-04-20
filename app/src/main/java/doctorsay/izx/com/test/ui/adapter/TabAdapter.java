package doctorsay.izx.com.test.ui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 *  tab适配器
 * Created by haohaitao on 17/4/6.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> stringList;

    public TabAdapter(FragmentManager fm, List<Fragment> fragments, List<String> stringList) {
        super(fm);
        mFragments = fragments;
        this.stringList = stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }

}
