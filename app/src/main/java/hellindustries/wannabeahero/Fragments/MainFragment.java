package hellindustries.wannabeahero.Fragments;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hellindustries.wannabeahero.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{


    private Button accidentBtn;
    private Button mutationBtn;
    private Button bornBtn;
    private Button chooseBtn;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        accidentBtn = (Button) view.findViewById(R.id.accidentBtn);
        mutationBtn = (Button) view.findViewById(R.id.mutationBtn);
        bornBtn = (Button) view.findViewById(R.id.bornBtn);
        chooseBtn = (Button) view.findViewById(R.id.chooseBtn);

        accidentBtn.setOnClickListener(this);
        mutationBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);

        chooseBtn.setEnabled(false);
        chooseBtn.getBackground().setAlpha(128);


        return view;

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public void onClick(View view) {
        chooseBtn.setEnabled(true);
        chooseBtn.getBackground().setAlpha(255);

        Button btn = (Button) view;

        if (btn == accidentBtn) {
            btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,R.drawable.item_selected,0);
            mutationBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,R.drawable.item_unselected,0);
            bornBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,R.drawable.item_unselected,0);
        } else if (btn == mutationBtn) {
            btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,R.drawable.item_selected,0);
            accidentBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,R.drawable.item_unselected,0);
            bornBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,R.drawable.item_unselected,0);
        } else if  (btn == bornBtn) {
            btn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,R.drawable.item_selected,0);
            accidentBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,R.drawable.item_unselected,0);
            mutationBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,R.drawable.item_unselected,0);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
