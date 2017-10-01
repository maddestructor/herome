package hellindustries.wannabeahero.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

import com.labo.kaji.fragmentanimations.MoveAnimation;

import hellindustries.wannabeahero.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {


    private PickPowerInteractionListener mListener;

    public static final int DURATION = 500;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PickPowerFragment.
     */
    public static PickPowerFragment newInstance() {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_power, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if(getFragmentManager().getBackStackEntryCount() == 2) {
            if(enter) {
                return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
            } else {
                return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
            }
        } else {
            if(enter) {
                return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
            } else {
                return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
            }
        }

    }

    @Override
    public void onClick(View view) {


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        void PickPowerInteraction(Uri uri);
    }
}
