package com.bakigoal.photogallery.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.bakigoal.photogallery.R;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResId());

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

    if (fragment == null) {
      fragment = createFragment();
      fragmentManager.beginTransaction()
          .add(R.id.fragment_container, fragment)
          .commit();
    }

  }

  protected abstract Fragment createFragment();

  protected int getLayoutResId() {
    return R.layout.activity_fragment;
  }

}
