package vesitlibrary.pavankumar.camp.VESITLibrary;

/** THIS PROJECT IS COPYRIGHT TO VESIT COLLAGE AND LIBRARY.TEAM AND APP DEVELOPERS ALL RIGHTS ARE RESERVED
 *
 *
 /**
 *
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import static vesitlibrary.pavankumar.camp.VESITLibrary.R.layout.list_item_book_display;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabEtrxFragment extends Fragment {

    private ListView lv;
    // Listview Adapter
    ArrayAdapter<String> adapter;
    // Search EditText
    EditText inputSearch;

    public TabEtrxFragment() {
        // Required empty public constructor
    }

    Toolbar toolbar;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_etrx, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        // Listview Data
        String products[] =
                {      "INTRODUCTION TO ENGINEERING PROG by \n HOLLOWAY JAMES PAUL",
                        "ADAPTIVE WCDMA by \n GLISIC S G",
                        "ADVANCED ELECTRONIC COMM  6/ED by \n TOMASI WAYNE",
                        "DIGITAL IMAGE PROCESSING 3/ED by \n PRATT WILLIAM K",
                        "DIGITAL INTEGRATED CIRCUITS 2/ED by \n RABAEY JAN M",
                        "DIGITAL SIGNAL PROCESSING by \n CRISTI ROBERTO",
                        "DIGITAL SIGNAL PROCESSING by \n CAVICCHI T J",
                        "DIGITAL SIGNAL PROCESSING by \n VENKATRAMANI B",
                        "DIGITAL SIGNAL PROCESSING FUN by \n LUDEMAN L C",


                        "ELECTRIC CIRCUITS 2/ED. by \n ALEXANDER",
                        "ELECTRONIC IMAGE PROCESSING by \n WEEKS A R",
                        "FIBER OPTICS COMMUNICATION by \n MYNBAEV DJAFOR",
                        "HDL CHIP DESIGN by \n SMITH D J",
                        "MICROWAVECIRCUIT DESIGN & ANA by \n LIAO SAMUEL",
                        "MOBILE COMMUNICATION SYSTEMS by \n WESLOWSKI K",
                        "MOBILE COMPUTING 2/ED by \n HANSMANN V",
                        "MULTIANTENNA TRANSRECEIVERS TECH by \n HOTTINEN ARI",
                        "OPTICAL COMMUNICATION NETWORK by \n ILYAS M",
                        "OPTICAL FIBER COMMUNICATIONS by \n GUPTA S C",
                        "OPTICAL NETWORKS 2/ED by \n RAMASWAMI R",
                        "ORTHOGONAL TRANSFORMS FOR D S P by \n RAO K K",
                        "RADAR PRINCIPLES by \n PEEBLES PZ",
                        "RF & MICROWAVESEMICONDUCTOR DEV by \n GOLIO  NIKO",
                        "RF SYSTEM DES PRACTICAL by \n EGAN W F",
                        "SINGLE & MULTICARRIER DS-CDMA by \n HANZO L",
                        "TELECOMMUNICATION MANAGEMENT by \n CARR H",
                        "TELECOMMUNICATION NETWORKS by \n SCHWARTZ M",
                        "VLSI DESIGN INTRODUCTION by \n FABRICIUS EUGENE D",
                        "WIRELESS LOCAL LOOPS by \n STARROULAKIS P",
                        "WIRELESS NETWORKS by \n NICOPOLITIDIS P",
                        "WIRELESS NETWORKS by \n PAHLAVAN KAVEH",
                        "WIRELESS NETWORKS by \n NICOPOLIDIS P",
                        "WIRELESS NETWORKS & MOBILE COMPUTING by \n STOJMENOVIC I",
                        "24 SILICON CONTROLLED RECTIFIER PROJECT by \n TRAISTER ROBERT J",
                        "25 SOLID STATE PROJECTS by \n GRAF R F",
                        "2672 CODE OF PRACTICE FOR LIBRARY LIGHTING by \n BUREAU OF INDIAN STANDARDS",
                        "2-D ELECTROMAGNETIC SIMULATION by \n JIMENEZ ALEJANDRA",
                        "3 RD GENERATION SYSTEMS & INTELLEGENT WN by \n BLOUGH J S",

                        "41 PROJECTS USING 741 IC by \n SHARMA M C",
                        "51 PROJECTS USING CD 4011 by \n SHARMA M C",
                        "555 TIMER  & ITS APPLICATIONS by \n SHARMA M C",
                        "802.11 WIRELESS NETWORKS 2/e by \n GAST MATTHEW",
                        "802.11 WIRELESS NETWORKS 2/ED by \n GAST MATHEW S",
                        "8051 MICROCONTROLLER by \n UDAYASHANKARA V",
                        "8051 MICROCONTROLLER by \n / MALLIKARJUNASWAMY M",

                        "8051 MICROCONTROLLER :AN APPLICATION BASED INTRODUCTION by \n CALCUTT DAVID",
                        "8051 MICROCONTROLLER :AN APPLICATION BASED INTRODUCTION by \n COWAN FRED",
                        "8051 MICROCONTROLLER :AN APPLICATION BASED INTRODUCTION by \n PARCHIZADEH HASSAN",

                        "8086 MICROPROCESSOR AND ITS APPLICATIONS by \n KANI A NAGOOR",
                        "A T M 3/ED by \n PRYCKER MARTIN",

                        "ACOUSTICAL ENGINEERING by \n OLSON H F",
                        "ACOUSTICS 2/ED by \n KINSLER L E",
                        "AD DIGITAL SIGNAL PROCESSING by \n VASEGHI",
                        "ADAPTIVE WCDMA THEORY & PRACTICE by \n GLISIC S G",
                        "ADAPTIVE FILTER THEORY by \n HAYKIN SIMON",
                        "ADAPTIVE FILTER THEORY 3/ED by \n HAYKIN",
                        "ADAPTIVE FILTER THEORY 4/ED by \n HAYKIN SIMON",
                        "ADAPTIVE FILTERING by \n GUSTAFSSON  F",
                        "ADAPTIVE SIGNAL PROCESSING by \n SIBUL",
                        "ADAPTIVE SIGNAL PROCESSING by \n WIDROW B",
                        "ADAPTIVE SIGNAL PROCESSING by \n WIDROW BERNARD",
                        "ADAPTIVE SIGNAL PROCESSING by \n BENESTY J",
                        "ADAPTIVE SIGNAL PROCESSING:NEXT GENERATION SOLUTIONS by \n ADALI TULAY",
                        "ADAPTIVE WIRELESS TRANSCEIVERS by \n HANZO L W",
                        "ADHOC AND SENSORS NETWORK 2 ED by \n CORDEIRO CARLOS DE",

                        "ADVANCED ASIC CHIP SYNTHESIS by \n BHATNAGAR HIMANSHU",
                        "ADVANCED DIGITAL COMMUNICATION SYSTEMS by \n NIIT",
                        "ADVANCED DIGITAL SIGNAL PROCESSING by \n PROAKIS J J",
                        "ADVANCED DIGITAL SIGNAL PROCESSING by \n ZELNIKAR GLEHN",
                        "ADVANCED ELECTRONIC COMMUNICATION SYSTEMS by \n TOMASI WAYNE",

                        "ADVANCED SWITCHED NETWORKS by \n NIIT",
                        "ADVANCES IN LASER PHYSICS AND TECHNOLOGY by \n MOHAN MAN",
                        "ADVANCES IN LASER PHYSICS AND TECHNOLOGY by \n MAINI ANUILKUMAR",
                        "AEROSPACE TELEMETRY by \n STILTZ HENRY",
                        "ALGO/STATSTICAL SIGNAL PROCESSING by \n PROAKIS J J",
                        "ALGORITHMS FOR VLSI DESIGN AUTOMATION by \n GEREZ SABIH H",

                        "ALTERNATING CURRENT CIRCUIT ANALYSIS by \n SEIPPEL R G",
                        "ALTERNATING CURRENT MACHINE by \n SAY M G",



                        "AMPLIFIERS WITH DISCRETE COMPONENTS by \n MONI R S",
                        "AN ENGINEERING APPROACH TO DIGITAL DESIGN by \n FLETCHER WILLIAM I",
                        "AN INTERACTIVE MULTIMEDIA INTRODUCTION TO SIGNAL PROCESSING 2ED by \n KARRENBERG ULRICH",
                        "AN INTRODUCTION TO ERROR ANALYSIS 2 ED by \n TAYLOR JHON R",
                        "AN INTRODUCTION TO LASERS: THEORY & APPLICATION by \n AVADHANULU",
                        "AN INTRODUCTION TO LASERS: THEORY & APPLICATION BY \n HEMNE P S",
                        "AN INTRODUCTION TO SIGNALS & SYSTEMS by \n STULLER JOHN ALAN",


                        "ANALOG & DIGITAL SIGNAL PROCESSING by \n AMBARDAR ASHOK",

                        "ANALOG AND DIGITAL COMMUNICATION 3/ED by \n HSU HWEI",
                        "ANALOG DIGITAL COMMUNICATION by \n HAYKIN SIMON",

                        "ANALOG ELECTRONICS by \n PRICE T E",
                        "ANALOG ELECTRONICS by \n MAHESHWARI L.K.",

                        "ANALOG FILTER DESIGN by \n VALKENBURG VAN",
                        "ANALOG FILTER DESIGN 2 ED by \n SCHAUMAN ROLF",
                        "ANALOG FILTER DESIGN 2 ED by \n XIAO HAIQIAO",
                        "ANALOG INTEGRATED CIRCUIT by \n SOCLOF SIDNEY",
                        "ANALOG INTEGRATED CIRCUITS DES by \n LAKER KENNETH",
                        "ANALOG INTEGRATED CKT ANA & DES by \n GRAY P R",
                        "ANALOG INTEGRATED CKTS by \n JACOB M A",
                        "ANALOG SIGNAL PROCESSING by \n PALAS ARENY",
                        "ANALOG/INTERFACE ICS DB 1 by \n MOTOROLA",
                        "ANALOG/INTERFACE ICS DB 2 by \n MOTOROLA",
                        "ANDRIOD APPLICATION DEVELOPMENT by \n ROGERS RICK",
                        "ANDRIOD APPLICATION DEVELOPMENT by \n LOMBARDO JHON",
                        "ANTENNA & WAVE PROPAGATION by \n PRASAD K D",
                        "ANTENNA & WAVE PROPAGATION 3/ED by \n PRASAD K D",
                        "ANTENNA & WAVE PROPOGATION by \n HARISH A R",
                        "ANTENNA & WAVE PROPOGATION by \n KISHORE",
                        "ANTENNA AND WAVE PROPOGATION by \n YADAV R L",
                        "ANTENNA ARRAYS by \n HAUPT RANDY",
                        "ANTENNA DESIGN 2/ED by \n MILLIGAN THOMAS A",
                        "ANTENNA ENGG HANDBOOK by \n JOHNSON R C",
                        "ANTENNA THEORY & DESIGN by \n ELLIOTT R S",
                        "ANTENNA THEORY & DESIGN (REV) ED by \n ELLIOTT R S",
                        "ANTENNA THEORY 2/ED by \n BALANIS C A",

                        "ANTENNA THEORY METHODS FOR NEXT GEN INTERNET 3/ED by \n BALANIS C A",
                        "ANTENNA THEORY WITH MULTIMEDIA 3/ED by \n BALANIS CONSTANTINE A",
                        "ANTENNA: FUNDAMENTAL DESIGN MEASUREMENT 3/ED by \n BLAKE LAMONT",
                        "ANTENNAS by \n COLLIN R E",

                        "ANTENNAS & PROPOGATION FOR WIRELESS COMM SYS 2/ED by \n SAUNDERS SIMON R",
                        "ANTENNAS & WAVE PRAPOGATION by \n RAJU G S N",
                        "ANTENNAS 2/ED by \n KRAUS J D",
                        "ANTENNAS AND WAVE PROPAGATION by \n RAJU GSM",
                        "ANTENNAS AND WAVE PROPAGATION by \n KRAUS JHON D",
                        "ANTENNAS AND WAVE PROPAGATION by \n MARHEFKA RONALD J",

                        "APACHE: WEB SERVER ADM by \n HAWKINS S",
                        "APPLICATION SPECIFIC INTEGRATED CKTS by \n MICHAEL JOHN",

                        "APPLIED CODING & INFORM. THEORY by \n WELLS RICHARD B",
                        "APPLIED ELECTRONICS by \n SEDHA R S",
                        "ATM ARCHITECT by \n MARTIN JAMES",
                        "ATM NETWORK CONCEPTS by \n HANDEL HUBER",

                        "ATM NETWORKS APP by \n HANDEL RAINER",

                        "ATM NETWORKS: CONCEPTS by \n KASERA SUMIT",
                        "ATM SWITCHING SYSTEMS by \n CHEN THOMAS M",
                        "AUDIO & VIDEO ENG by \n GUPTA R G",
                        "AUDIO VIDEO SYSTEMS by \n BALI S P",
                        "AUDIO-VIDEO SYSTEMS 2/ED by \n GUPTA R G",
                        "AUTOMATIVE SENSORS by \n TURNER JHON",
                        "AUTOMOBILE GUIDE by \n BRICKER F",

                        "BASIC ELECTRICAL & ELECTRONICS ENGG by \n SINGH RAVISH R",
                        "BASIC ELECTRICAL & ELECTRONICS ENGG by \n RAJALAKSHMI G",
                        "BASIC ELECTRICAL & ELECTRONICS ENGG by \n SIVANANDHAM M",
                        "BASIC ELECTRICAL AND ELECTRONICS ENGG by \n PATIL B R"
                };

        lv = (ListView)  rootView.findViewById(R.id.list_view);
        inputSearch = (EditText)  rootView.findViewById(R.id.inputSearch);
        lv.setOnItemClickListener(onListClick);


        // Adding items to listview
        adapter = new ArrayAdapter<>(getActivity(), list_item_book_display, R.id.product_name, products);
        lv.setAdapter(adapter);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                TabEtrxFragment.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

        return rootView;
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener(){

        public void onItemClick(AdapterView<?> parent, View view, int pos, long id){

            Intent i = new Intent(getActivity().getBaseContext(), BookDisplayEtrxActivity.class);
            i.putExtra("idbyetrx", pos);
            startActivity(i);
        }
    };


}
