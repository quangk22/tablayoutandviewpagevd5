package org.o7planning.tablayoutandviewpagevd5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = ItemListFragment.newInstance(0);
                break;
            case 1:
                frag = ItemListFragment.newInstance(1);
                break;
            case 2:
                frag = ItemListFragment.newInstance(2);
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = "Nước Ngoài";
                break;
            case 1:
                title = "Việt Nam";
                break;
        }
        return title;
    }
}
