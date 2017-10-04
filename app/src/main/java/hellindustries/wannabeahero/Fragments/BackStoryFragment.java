package hellindustries.wannabeahero.Fragments;

import android.content.Context;
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
 * {@link BackStoryFragment.OnStartOverInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackStoryFragment extends Fragment implements View.OnClickListener {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_POWER_ACQUISITION = "Power Acquisition";
    private static final String ARG_MAIN_POWER_CHOICE = "Main Power Choice";
    public static final int DURATION = 500;

    private int powerAcquisitionChoice;
    private int mainPowerChoice;

    private Button startOverBtn;

    private OnStartOverInteractionListener mListener;

    public BackStoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param powerAcquisitionChoice
     * @param mainPowerChoice
     * @return A new instance of fragment BackStoryFragment.
     */
    public static BackStoryFragment newInstance(int powerAcquisitionChoice, int mainPowerChoice) {
        BackStoryFragment fragment = new BackStoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POWER_ACQUISITION, powerAcquisitionChoice);
        args.putInt(ARG_MAIN_POWER_CHOICE, mainPowerChoice);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            powerAcquisitionChoice = getArguments().getInt(ARG_POWER_ACQUISITION);
            mainPowerChoice = getArguments().getInt(ARG_MAIN_POWER_CHOICE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_back_story, container, false);

        startOverBtn = (Button) view.findViewById(R.id.startOverBtn);
        startOverBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStartOverInteractionListener) {
            mListener = (OnStartOverInteractionListener) context;
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

        if (enter) {
            return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
        } else {
            return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
        }

    }

    @Override
    public void onClick(View view) {

        Button btn = (Button) view;

        if (btn == startOverBtn) {
            mListener.onStartOverInteraction();
        }
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
    public interface OnStartOverInteractionListener {
        void onStartOverInteraction();
    }
}
