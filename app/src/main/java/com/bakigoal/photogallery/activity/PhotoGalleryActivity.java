package com.bakigoal.photogallery.activity;

import android.support.v4.app.Fragment;

import com.bakigoal.photogallery.fragment.PhotoGalleryFragment;

public class PhotoGalleryActivity extends SingleFragmentActivity{
  @Override
  protected Fragment createFragment() {
    return new PhotoGalleryFragment();
  }
}
