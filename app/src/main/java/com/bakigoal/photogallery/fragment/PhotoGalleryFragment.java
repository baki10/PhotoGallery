package com.bakigoal.photogallery.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.bakigoal.photogallery.R;
import com.bakigoal.photogallery.model.GalleryItem;
import com.bakigoal.photogallery.util.FlickrFetchr;

import java.util.ArrayList;
import java.util.List;

public class PhotoGalleryFragment extends Fragment {

  private static final String TAG = "PhotoGalleryFragment";
  List<GalleryItem> items;
  private GridView gridView;

  public PhotoGalleryFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
    new FetchItemsTask().execute();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
    gridView = (GridView) view.findViewById(R.id.gridView);
    setupAdapter();
    return view;
  }

  private void setupAdapter() {
    if (getActivity() == null || gridView == null) {
      return;
    }
    if (items != null) {
      gridView.setAdapter(new ArrayAdapter<>(getActivity(),
          android.R.layout.simple_gallery_item, items));
    } else {
      gridView.setAdapter(null);
    }
  }

  private class FetchItemsTask extends AsyncTask<Void, Void, List<GalleryItem>> {

    @Override
    protected List<GalleryItem> doInBackground(Void... params) {
      items = new FlickrFetchr().fetchItems();
      return items;
    }

    @Override
    protected void onPostExecute(List<GalleryItem> galleryItems) {
      items = galleryItems;
      setupAdapter();
    }
  }

}
