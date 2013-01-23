package com.example.testgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockMapFragment;
import com.example.testgooglemaps.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen. This fragment is either
 * contained in a {@link ItemListActivity} in two-pane mode (on tablets) or a
 * {@link ItemDetailActivity} on handsets.
 */
public class ItemDetailFragment extends SherlockFragment {

	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (savedInstanceState != null)
			return null;

		View rootView = inflater.inflate(R.layout.fragment_item_detail,
				container, false);
		Log.d("POPO", "ItemDetailFragment - onCreateView B");
		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			TextView a = (TextView) rootView
					.findViewById(R.id.item_detail_text);
			a.setText(mItem.content);

			SherlockMapFragment mapFragment = (SherlockMapFragment) getSherlockActivity()
					.getSupportFragmentManager().findFragmentByTag(
							"tag_fragment_map");
			if (mapFragment == null) {
				mapFragment = MapFragment.newInstance("address", "nombre");
				FragmentTransaction fragmentTransaction = getSherlockActivity()
						.getSupportFragmentManager().beginTransaction();
				fragmentTransaction.replace(R.id.fragment_map, mapFragment,
						"tag_fragment_map");
				fragmentTransaction.commit();
				mapFragment.setRetainInstance(true);
			}

			//
			// ((TextView) rootView.findViewById(R.id.item_detail))
			// .setText(mItem.content);
		}

		return rootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		// SherlockMapFragment mapFragment = (SherlockMapFragment)
		// getSherlockActivity().getSupportFragmentManager()
		// .findFragmentByTag("tag_fragment_map");
		// if (mapFragment==null)
		// {
		// mapFragment = MapFragment.newInstance("address","nombre");
		// FragmentTransaction fragmentTransaction =
		// getSherlockActivity().getSupportFragmentManager()
		// .beginTransaction();
		// fragmentTransaction.add(R.id.fragment_map, mapFragment,
		// "tag_fragment_map");
		// fragmentTransaction.commit();
		// }
		// else
		// {
		//
		// }
	}

}
