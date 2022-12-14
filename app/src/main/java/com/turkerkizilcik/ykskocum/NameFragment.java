package com.turkerkizilcik.ykskocum;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Locale;


public class NameFragment extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioButtonSay, radioButtonSoz, radioButtonEA, radioButtonDil, radioButton;
    Button button;
    SharedPreferences sharedPreferences;
    EditText personName;

    private FirebaseAuth mAuth;

    TextView textView;
    ArrayList<String> arrayList;
    Dialog dialog;

    TextView textViewBolum;
    ArrayList<String> arrayListBolum;
    Dialog dialogBolum;


    FirebaseDatabase database;
    DatabaseReference databaseReference;
    public NameFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    public void upload (View view) {


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioButtonSay = view.findViewById(R.id.radioButtonSayisal);
        radioButtonSoz = view.findViewById(R.id.radioButtonSozel);
        radioButtonEA = view.findViewById(R.id.radioButtonEA);
        radioButtonDil = view.findViewById(R.id.radioButtonDil);
        button = view.findViewById(R.id.buttonSaver);
        personName = view.findViewById(R.id.editTextPersonName);
        radioGroup = view.findViewById(R.id.radioGroup);
        sharedPreferences = this.getActivity().getSharedPreferences("com.turkerkizilcik.ykskocum", Context.MODE_PRIVATE);

        textView = view.findViewById(R.id.text_view);
        textViewBolum = view.findViewById(R.id.text_view_bolum);

        //database = FirebaseDatabase.getInstance();
        //databaseReference = database.getReference("https://ykskocum-7ba62-default-rtdb.firebaseio.com");
        //databaseReference.child("").setValue("da????a????m");


        database = FirebaseDatabase.getInstance("https://ykskocum-7ba62-default-rtdb.firebaseio.com/");
        databaseReference = database.getReference("Profiller");


        arrayList = new ArrayList<>();
        arrayList.add("-----DEVLET ??N??VERS??TELER??-----");
        arrayList.add("ABDULLAH G??L ??N??VERS??TES??                                   ");
        arrayList.add("ADANA ALPARSLAN T??RKE?? B??L??M VE TEKNOLOJ?? ??N??VERS??TES??      ");
        arrayList.add("ADIYAMAN ??N??VERS??TES??                                       ");
        arrayList.add("AFYON KOCATEPE ??N??VERS??TES??                                 ");
        arrayList.add("AFYONKARAH??SAR SA??LIK B??L??MLER?? ??N??VERS??TES??                ");
        arrayList.add("A??RI ??BRAH??M ??E??EN ??N??VERS??TES??                             ");
        arrayList.add("AKDEN??Z ??N??VERS??TES??                                        ");
        arrayList.add("AKSARAY ??N??VERS??TES??                                        ");
        arrayList.add("ALANYA ALAADD??N KEYKUBAT ??N??VERS??TES??                       ");
        arrayList.add("AMASYA ??N??VERS??TES??                                         ");
        arrayList.add("ANADOLU ??N??VERS??TES??                                        ");
        arrayList.add("ANKARA HACI BAYRAM VEL?? ??N??VERS??TES??                        ");
        arrayList.add("ANKARA SOSYAL B??L??MLER ??N??VERS??TES??                         ");
        arrayList.add("ANKARA ??N??VERS??TES??                                         ");
        arrayList.add("ANKARA YILDIRIM BEYAZIT ??N??VERS??TES??                        ");
        arrayList.add("ARDAHAN ??N??VERS??TES??                                        ");
        arrayList.add("ARTV??N ??ORUH ??N??VERS??TES??                                   ");
        arrayList.add("ATAT??RK ??N??VERS??TES??                                        ");
        arrayList.add("AYDIN ADNAN MENDERES ??N??VERS??TES??                           ");
        arrayList.add("BALIKES??R ??N??VERS??TES??                                      ");
        arrayList.add("BANDIRMA ONYED?? EYL??L ??N??VERS??TES??                          ");
        arrayList.add("BARTIN ??N??VERS??TES??                                         ");
        arrayList.add("BATMAN ??N??VERS??TES??                                         ");
        arrayList.add("BAYBURT ??N??VERS??TES??                                        ");
        arrayList.add("B??LEC??K ??EYH EDEBAL?? ??N??VERS??TES??                           ");
        arrayList.add("B??NG??L ??N??VERS??TES??                                         ");
        arrayList.add("B??TL??S EREN ??N??VERS??TES??                                    ");
        arrayList.add("BO??AZ?????? ??N??VERS??TES??                                       ");
        arrayList.add("BOLU ABANT ??ZZET BAYSAL ??N??VERS??TES??                        ");
        arrayList.add("BURDUR MEHMET AK??F ERSOY ??N??VERS??TES??                       ");
        arrayList.add("BURSA TEKN??K ??N??VERS??TES??                                   ");
        arrayList.add("BURSA ULUDA?? ??N??VERS??TES??                                   ");
        arrayList.add("??ANAKKALE ONSEK??Z MART ??N??VERS??TES??                         ");
        arrayList.add("??ANKIRI KARATEK??N ??N??VERS??TES??                              ");
        arrayList.add("??UKUROVA ??N??VERS??TES??                                       ");
        arrayList.add("D??CLE ??N??VERS??TES??                                          ");
        arrayList.add("DOKUZ EYL??L ??N??VERS??TES??                                    ");
        arrayList.add("D??ZCE ??N??VERS??TES??                                          ");
        arrayList.add("EGE ??N??VERS??TES??                                            ");
        arrayList.add("ERC??YES ??N??VERS??TES??                                        ");
        arrayList.add("ERZ??NCAN B??NAL?? YILDIRIM ??N??VERS??TES??                       ");
        arrayList.add("ERZURUM TEKN??K ??N??VERS??TES??                                 ");
        arrayList.add("ESK????EH??R OSMANGAZ?? ??N??VERS??TES??                            ");
        arrayList.add("ESK????EH??R TEKN??K ??N??VERS??TES??                               ");
        arrayList.add("FIRAT ??N??VERS??TES??                                          ");
        arrayList.add("GALATASARAY ??N??VERS??TES??                                    ");
        arrayList.add("GAZ?? ??N??VERS??TES??                                           ");
        arrayList.add("GAZ??ANTEP ??SLAM B??L??M VE TEKNOLOJ?? ??N??VERS??TES??             ");
        arrayList.add("GAZ??ANTEP ??N??VERS??TES??                                      ");
        arrayList.add("GEBZE TEKN??K ??N??VERS??TES??                                   ");
        arrayList.add("G??RESUN ??N??VERS??TES??                                        ");
        arrayList.add("G??M????HANE ??N??VERS??TES??                                      ");
        arrayList.add("HACETTEPE ??N??VERS??TES??                                      ");
        arrayList.add("HAKKAR?? ??N??VERS??TES??                                        ");
        arrayList.add("HARRAN ??N??VERS??TES??                                         ");
        arrayList.add("HATAY MUSTAFA KEMAL ??N??VERS??TES??                            ");
        arrayList.add("H??T??T ??N??VERS??TES??                                          ");
        arrayList.add("I??DIR ??N??VERS??TES??                                          ");
        arrayList.add("ISPARTA UYGULAMALI B??L??MLER ??N??VERS??TES??                    ");
        arrayList.add("??N??N?? ??N??VERS??TES??                                          ");
        arrayList.add("??SKENDERUN TEKN??K ??N??VERS??TES??                              ");
        arrayList.add("??STANBUL MEDEN??YET ??N??VERS??TES??                             ");
        arrayList.add("??STANBUL TEKN??K ??N??VERS??TES??                                ");
        arrayList.add("??STANBUL ??N??VERS??TES??                                       ");
        arrayList.add("??STANBUL ??N??VERS??TES??-CERRAHPA??A                            ");
        arrayList.add("??ZM??R BAKIR??AY ??N??VERS??TES??                                 ");
        arrayList.add("??ZM??R DEMOKRAS?? ??N??VERS??TES??                                ");
        arrayList.add("??ZM??R KAT??P ??ELEB?? ??N??VERS??TES??                             ");
        arrayList.add("??ZM??R Y??KSEK TEKNOLOJ?? ENST??T??S??                            ");
        arrayList.add("KAFKAS ??N??VERS??TES??                                         ");
        arrayList.add("KAHRAMANMARA?? ??ST??KLAL ??N??VERS??TES??                         ");
        arrayList.add("KAHRAMANMARA?? S??T???? ??MAM ??N??VERS??TES??                       ");
        arrayList.add("KARAB??K ??N??VERS??TES??                                        ");
        arrayList.add("KARADEN??Z TEKN??K ??N??VERS??TES??                               ");
        arrayList.add("KARAMANO??LU MEHMETBEY ??N??VERS??TES??                          ");
        arrayList.add("KASTAMONU ??N??VERS??TES??                                      ");
        arrayList.add("KAYSER?? ??N??VERS??TES??                                        ");
        arrayList.add("KIRIKKALE ??N??VERS??TES??                                      ");
        arrayList.add("KIRKLAREL?? ??N??VERS??TES??                                     ");
        arrayList.add("KIR??EH??R AH?? EVRAN ??N??VERS??TES??                             ");
        arrayList.add("K??L??S 7 ARALIK ??N??VERS??TES??                                 ");
        arrayList.add("KOCAEL?? ??N??VERS??TES??                                        ");
        arrayList.add("KONYA TEKN??K ??N??VERS??TES??                                   ");
        arrayList.add("K??TAHYA DUMLUPINAR ??N??VERS??TES??                             ");
        arrayList.add("K??TAHYA SA??LIK B??L??MLER?? ??N??VERS??TES??                       ");
        arrayList.add("MALATYA TURGUT ??ZAL ??N??VERS??TES??                            ");
        arrayList.add("MAN??SA CEL??L BAYAR ??N??VERS??TES??                             ");
        arrayList.add("MARD??N ARTUKLU ??N??VERS??TES??                                 ");
        arrayList.add("MARMARA ??N??VERS??TES??                                        ");
        arrayList.add("MERS??N ??N??VERS??TES??                                         ");
        arrayList.add("M??MAR S??NAN G??ZEL SANATLAR ??N??VERS??TES??                     ");
        arrayList.add("MU??LA SITKI KO??MAN ??N??VERS??TES??                             ");
        arrayList.add("MUNZUR ??N??VERS??TES??                                         ");
        arrayList.add("MU?? ALPARSLAN ??N??VERS??TES??                                  ");
        arrayList.add("NECMETT??N ERBAKAN ??N??VERS??TES??                              ");
        arrayList.add("NEV??EH??R HACI BEKTA?? VEL?? ??N??VERS??TES??                      ");
        arrayList.add("N????DE ??MER HAL??SDEM??R ??N??VERS??TES??                          ");
        arrayList.add("ONDOKUZ MAYIS ??N??VERS??TES??                                  ");
        arrayList.add("ORDU ??N??VERS??TES??                                           ");
        arrayList.add("ORTA DO??U TEKN??K ??N??VERS??TES??                               ");
        arrayList.add("OSMAN??YE KORKUT ATA ??N??VERS??TES??                            ");
        arrayList.add("PAMUKKALE ??N??VERS??TES??                                      ");
        arrayList.add("RECEP TAYY??P ERDO??AN ??N??VERS??TES??                           ");
        arrayList.add("SA??LIK B??L??MLER?? ??N??VERS??TES??                               ");
        arrayList.add("SAKARYA UYGULAMALI B??L??MLER ??N??VERS??TES??                    ");
        arrayList.add("SAKARYA ??N??VERS??TES??                                        ");
        arrayList.add("SAMSUN ??N??VERS??TES??                                         ");
        arrayList.add("SEL??UK ??N??VERS??TES??                                         ");
        arrayList.add("S????RT ??N??VERS??TES??                                          ");
        arrayList.add("S??NOP ??N??VERS??TES??                                          ");
        arrayList.add("S??VAS B??L??M VE TEKNOLOJ?? ??N??VERS??TES??                       ");
        arrayList.add("S??VAS CUMHUR??YET ??N??VERS??TES??                               ");
        arrayList.add("S??LEYMAN DEM??REL ??N??VERS??TES??                               ");
        arrayList.add("??IRNAK ??N??VERS??TES??                                         ");
        arrayList.add("TARSUS ??N??VERS??TES??                                         ");
        arrayList.add("TEK??RDA?? NAMIK KEMAL ??N??VERS??TES??                           ");
        arrayList.add("TOKAT GAZ??OSMANPA??A ??N??VERS??TES??                            ");
        arrayList.add("TRABZON ??N??VERS??TES??                                        ");
        arrayList.add("TRAKYA ??N??VERS??TES??                                         ");
        arrayList.add("T??RK-ALMAN ??N??VERS??TES??                                     ");
        arrayList.add("U??AK ??N??VERS??TES??                                           ");
        arrayList.add("VAN Y??Z??NC?? YIL ??N??VERS??TES??                                ");
        arrayList.add("YALOVA ??N??VERS??TES??                                         ");
        arrayList.add("YILDIZ TEKN??K ??N??VERS??TES??                                  ");
        arrayList.add("YOZGAT BOZOK ??N??VERS??TES??                                   ");
        arrayList.add("ZONGULDAK B??LENT ECEV??T ??N??VERS??TES??                        ");
        arrayList.add("-----VAKIF ??N??VERS??TELER??-----");
        arrayList.add("ACIBADEM MEHMET AL?? AYDINLAR ??N??VERS??TES??                    ");
        arrayList.add("ALANYA HAMDULLAH EM??N PA??A ??N??VERS??TES??                      ");
        arrayList.add("ALTINBA?? ??N??VERS??TES??                                        ");
        arrayList.add("ANKARA B??L??M ??N??VERS??TES??                                    ");
        arrayList.add("ANKARA MED??POL ??N??VERS??TES??                                  ");
        arrayList.add("ANTALYA AKEV ??N??VERS??TES??                                    ");
        arrayList.add("ANTALYA B??L??M ??N??VERS??TES??                                   ");
        arrayList.add("ATILIM ??N??VERS??TES??                                          ");
        arrayList.add("AVRASYA ??N??VERS??TES??                                         ");
        arrayList.add("BAH??E??EH??R ??N??VERS??TES??                                      ");
        arrayList.add("BA??KENT ??N??VERS??TES??                                         ");
        arrayList.add("BEYKENT ??N??VERS??TES??                                         ");
        arrayList.add("BEYKOZ ??N??VERS??TES??                                          ");
        arrayList.add("BEZM-?? ??LEM VAKIF ??N??VERS??TES??                               ");
        arrayList.add("B??RUN?? ??N??VERS??TES??                                          ");
        arrayList.add("??A?? ??N??VERS??TES??                                             ");
        arrayList.add("??ANKAYA ??N??VERS??TES??                                         ");
        arrayList.add("DEM??RO??LU B??L??M ??N??VERS??TES??                                 ");
        arrayList.add("DO??U?? ??N??VERS??TES??                                           ");
        arrayList.add("FAT??H SULTAN MEHMET VAKIF ??N??VERS??TES??                       ");
        arrayList.add("FENERBAH??E ??N??VERS??TES??                                      ");
        arrayList.add("HAL???? ??N??VERS??TES??                                           ");
        arrayList.add("HASAN KALYONCU ??N??VERS??TES??                                  ");
        arrayList.add("I??IK ??N??VERS??TES??                                            ");
        arrayList.add("??BN HALDUN ??N??VERS??TES??                                      ");
        arrayList.add("??HSAN DO??RAMACI B??LKENT ??N??VERS??TES??                         ");
        arrayList.add("??STANBUL 29 MAYIS ??N??VERS??TES??                               ");
        arrayList.add("??STANBUL AREL ??N??VERS??TES??                                   ");
        arrayList.add("??STANBUL ATLAS ??N??VERS??TES??                                  ");
        arrayList.add("??STANBUL AYDIN ??N??VERS??TES??                                  ");
        arrayList.add("??STANBUL B??LG?? ??N??VERS??TES??                                  ");
        arrayList.add("??STANBUL ESENYURT ??N??VERS??TES??                               ");
        arrayList.add("??STANBUL GALATA ??N??VERS??TES??                                 ");
        arrayList.add("??STANBUL GED??K ??N??VERS??TES??                                  ");
        arrayList.add("??STANBUL GEL??????M ??N??VERS??TES??                                ");
        arrayList.add("??STANBUL KENT ??N??VERS??TES??                                   ");
        arrayList.add("??STANBUL K??LT??R ??N??VERS??TES??                                 ");
        arrayList.add("??STANBUL MED??POL ??N??VERS??TES??                                ");
        arrayList.add("??STANBUL OKAN ??N??VERS??TES??                                   ");
        arrayList.add("??STANBUL RUMEL?? ??N??VERS??TES??                                 ");
        arrayList.add("??STANBUL SABAHATT??N ZA??M ??N??VERS??TES??                        ");
        arrayList.add("??STANBUL SA??LIK VE TEKNOLOJ?? ??N??VERS??TES??                    ");
        arrayList.add("??STANBUL T??CARET ??N??VERS??TES??                                ");
        arrayList.add("??STANBUL TOPKAPI ??N??VERS??TES??                                ");
        arrayList.add("??STANBUL YEN?? Y??ZYIL ??N??VERS??TES??                            ");
        arrayList.add("??ST??NYE ??N??VERS??TES??                                         ");
        arrayList.add("??ZM??R EKONOM?? ??N??VERS??TES??                                   ");
        arrayList.add("??ZM??R TINAZTEPE ??N??VERS??TES??                                 ");
        arrayList.add("KAD??R HAS ??N??VERS??TES??                                       ");
        arrayList.add("KAPADOKYA ??N??VERS??TES??                                       ");
        arrayList.add("KOCAEL?? SA??LIK VE TEKNOLOJ?? ??N??VERS??TES??                     ");
        arrayList.add("KO?? ??N??VERS??TES??                                             ");
        arrayList.add("KONYA GIDA VE TARIM ??N??VERS??TES??                             ");
        arrayList.add("KTO KARATAY ??N??VERS??TES??                                     ");
        arrayList.add("LOKMAN HEK??M ??N??VERS??TES??                                    ");
        arrayList.add("MALTEPE ??N??VERS??TES??                                         ");
        arrayList.add("MEF ??N??VERS??TES??                                             ");
        arrayList.add("MUDANYA ??N??VERS??TES??                                         ");
        arrayList.add("N????ANTA??I ??N??VERS??TES??                                       ");
        arrayList.add("NUH NAC?? YAZGAN ??N??VERS??TES??                                 ");
        arrayList.add("OST??M TEKN??K ??N??VERS??TES??                                    ");
        arrayList.add("??ZYE????N ??N??VERS??TES??                                         ");
        arrayList.add("P??R?? RE??S ??N??VERS??TES??                                       ");
        arrayList.add("SABANCI ??N??VERS??TES??                                         ");
        arrayList.add("SANKO ??N??VERS??TES??                                           ");
        arrayList.add("TED ??N??VERS??TES??                                             ");
        arrayList.add("TOBB EKONOM?? VE TEKNOLOJ?? ??N??VERS??TES??                       ");
        arrayList.add("TOROS ??N??VERS??TES??                                           ");
        arrayList.add("T??RK HAVA KURUMU ??N??VERS??TES??                                ");
        arrayList.add("UFUK ??N??VERS??TES??                                            ");
        arrayList.add("??SK??DAR ??N??VERS??TES??                                         ");
        arrayList.add("YA??AR ??N??VERS??TES??                                           ");
        arrayList.add("YED??TEPE ??N??VERS??TES??                                        ");
        arrayList.add("Y??KSEK ??HT??SAS ??N??VERS??TES??                                  ");
        arrayList.add("-----KKTC ??N??VERS??TELER??-----");
        arrayList.add("ADA KENT ??N??VERS??TES??                           ");
        arrayList.add("AKDEN??Z KARPAZ ??N??VERS??TES??                     ");
        arrayList.add("ARKIN YARATICI SANATLAR VE TASARIM ??N??VERS??TES?? ");
        arrayList.add("BAH??E??EH??R KIBRIS ??N??VERS??TES??                  ");
        arrayList.add("DO??U AKDEN??Z ??N??VERS??TES??                       ");
        arrayList.add("G??RNE AMER??KAN ??N??VERS??TES??                     ");
        arrayList.add("G??RNE ??N??VERS??TES??                              ");
        arrayList.add("KIBRIS AMER??KAN ??N??VERS??TES??                    ");
        arrayList.add("KIBRIS BATI ??N??VERS??TES??                        ");
        arrayList.add("KIBRIS ??L??M ??N??VERS??TES??                        ");
        arrayList.add("KIBRIS SA??LIK VE TOPLUM B??L??MLER?? ??N??VERS??TES??  ");
        arrayList.add("LEFKE AVRUPA ??N??VERS??TES??                       ");
        arrayList.add("RAUF DENKTA?? ??N??VERS??TES??                       ");
        arrayList.add("ULUSLARARASI F??NAL ??N??VERS??TES??                 ");
        arrayList.add("ULUSLARARASI KIBRIS ??N??VERS??TES??                ");
        arrayList.add("YAKIN DO??U ??N??VERS??TES??                         ");
        arrayList.add("-----YURT DI??I ??N??VERS??TELER??-----");
        arrayList.add("AZERBAYCAN DEVLET PEDAGOJ?? ??N??VERS??TES??               ");
        arrayList.add("AZERBAYCAN D??LLER ??N??VERS??TES??                        ");
        arrayList.add("AZERBAYCAN TIP ??N??VERS??TES??                           ");
        arrayList.add("BAK?? DEVLET ??N??VERS??TES??                              ");
        arrayList.add("HOCA AHMET YESEV?? ULUSLARARASI T??RK-KAZAK ??N??VERS??TES??");
        arrayList.add("KIRGIZ??STAN-T??RK??YE MANAS ??N??VERS??TES??                ");
        arrayList.add("KOMRAT DEVLET ??N??VERS??TES??                            ");
        arrayList.add("ULUSLARARASI BALKAN ??N??VERS??TES??                      ");
        arrayList.add("ULUSLARARASI SARAYBOSNA ??N??VERS??TES??                  ");

        arrayListBolum = new ArrayList<>();
        arrayListBolum.add("Antropoloji                                                ");
        arrayListBolum.add("Etnoloji                                                   ");
        arrayListBolum.add("Halkbilim                                                  ");
        arrayListBolum.add("Sosyal Antropoloji                                         ");
        arrayListBolum.add("T??rk Halkbilimi                                            ");
        arrayListBolum.add("Arkeoloji                                                  ");
        arrayListBolum.add("Arkeoloji Ve Sanat Tarihi                                  ");
        arrayListBolum.add("Klasik Arkeoloji                                           ");
        arrayListBolum.add("K??lt??r Varl??klar??n?? Koruma Ve Onar??m                       ");
        arrayListBolum.add("Prehistorya                                                ");
        arrayListBolum.add("Protohistorya Ve ??n Asya Arkeolojisi                       ");
        arrayListBolum.add("Tarih ??ncesi Arkeolojisi                                   ");
        arrayListBolum.add("Ta????nabilir K??lt??r Varl??klar??n?? Koruma Ve Onar??m           ");
        arrayListBolum.add("Bankac??l??k                                                 ");
        arrayListBolum.add("Bankac??l??k Ve Finans                                       ");
        arrayListBolum.add("Bankac??l??k Ve Sigortac??l??k                                 ");
        arrayListBolum.add("Sermaye Piyasalar?? Ve Portf??y Y??netimi                     ");
        arrayListBolum.add("Sermaye Piyasas??                                           ");
        arrayListBolum.add("Sermaye Piyasas?? Denetim Ve Derecelendirme                 ");
        arrayListBolum.add("Sigortac??l??k                                               ");
        arrayListBolum.add("Sigortac??l??k Ve Risk Y??netimi                              ");
        arrayListBolum.add("Sigortac??l??k Ve Sosyal G??venlik                            ");
        arrayListBolum.add("Beslenme Ve Diyetetik                                      ");
        arrayListBolum.add("Adli Bili??im M??hendisli??i                                  ");
        arrayListBolum.add("Bilgisayar Bilimi Ve M??hendisli??i                          ");
        arrayListBolum.add("Bilgisayar M??hendisli??i                                    ");
        arrayListBolum.add("Bilgisayar Ve Yaz??l??m M??hendisli??i                         ");
        arrayListBolum.add("Bili??im Sistemleri M??hendisli??i                            ");
        arrayListBolum.add("Yaz??l??m M??hendisli??i                                       ");
        arrayListBolum.add("Biyoloji                                                   ");
        arrayListBolum.add("Biyom??hendislik                                            ");
        arrayListBolum.add("Biyoenformatik Ve Genetik                                  ");
        arrayListBolum.add("Biyomedikal M??hendisli??i                                   ");
        arrayListBolum.add("Biyosistem M??hendisli??i                                    ");
        arrayListBolum.add("Biyoteknoloji                                              ");
        arrayListBolum.add("Biyoteknoloji Ve Molek??ler Biyoloji                        ");
        arrayListBolum.add("Genetik Ve Biyoinformatik                                  ");
        arrayListBolum.add("Genetik Ve Biyom??hendislik                                 ");
        arrayListBolum.add("Molek??ler Biyoloji Ve Genetik                              ");
        arrayListBolum.add("Molek??ler Biyoloji, Genetik Ve Biyom??hendislik             ");
        arrayListBolum.add("T??p M??hendisli??i                                           ");
        arrayListBolum.add("Co??rafya                                                   ");
        arrayListBolum.add("??al????ma Ekonomisi Ve End??stri ??li??kileri                   ");
        arrayListBolum.add("??evre M??hendisli??i                                         ");
        arrayListBolum.add("Di?? Hekimli??i                                              ");
        arrayListBolum.add("Eczac??l??k                                                  ");
        arrayListBolum.add("Ekonometri                                                 ");
        arrayListBolum.add("Finansal Ekonometri                                        ");
        arrayListBolum.add("Elektrik M??hendisli??i                                      ");
        arrayListBolum.add("Elektrik Ve Elektronik M??hendisli??i                        ");
        arrayListBolum.add("Elektronik M??hendisli??i                                    ");
        arrayListBolum.add("Elektronik Ve Haberle??me M??hendisli??i                      ");
        arrayListBolum.add("Telekom??nikasyon M??hendisli??i                              ");
        arrayListBolum.add("End??stri M??hendisli??i                                      ");
        arrayListBolum.add("End??stri Sistemleri M??hendisli??i                           ");
        arrayListBolum.add("End??stri Ve Sistem M??hendisli??i                            ");
        arrayListBolum.add("????letme M??hendisli??i                                       ");
        arrayListBolum.add("Sistem M??hendisli??i                                        ");
        arrayListBolum.add("End??stri Tasar??m??                                          ");
        arrayListBolum.add("End??stri ??r??nleri Tasar??m??                                 ");
        arrayListBolum.add("End??striyel Tasar??m                                        ");
        arrayListBolum.add("End??striyel Tasar??m M??hendisli??i                           ");
        arrayListBolum.add("Ekonomi Politik Ve Toplum Felsefesi                        ");
        arrayListBolum.add("Felsefe                                                    ");
        arrayListBolum.add("Astronomi Ve Uzay Bilimleri                                ");
        arrayListBolum.add("Fizik                                                      ");
        arrayListBolum.add("Fizik M??hendisli??i                                         ");
        arrayListBolum.add("Optik Ve Akustik M??hendisli??i                              ");
        arrayListBolum.add("Uzay Bilimleri Ve Teknolojileri                            ");
        arrayListBolum.add("Ergoterapi                                                 ");
        arrayListBolum.add("Fizik Tedavi Ve Rehabilitasyon                             ");
        arrayListBolum.add("Deniz Teknolojisi M??hendisli??i                             ");
        arrayListBolum.add("Deniz Ula??t??rma ????letme M??hendisli??i                       ");
        arrayListBolum.add("Gemi ??n??a Ve Gemi Makineleri M??hendisli??i                  ");
        arrayListBolum.add("Gemi ??n??aat?? M??hendisli??i                                  ");
        arrayListBolum.add("Gemi ??n??aat?? Ve Gemi Makineleri M??hendisli??i               ");
        arrayListBolum.add("Gemi Makineleri ????letme M??hendisli??i                       ");
        arrayListBolum.add("Gemi Ve Deniz Teknolojisi M??hendisli??i                     ");
        arrayListBolum.add("G??da M??hendisli??i                                          ");
        arrayListBolum.add("Aksesuar Tasar??m??                                          ");
        arrayListBolum.add("Bask?? Sanatlar??                                            ");
        arrayListBolum.add("Bile??ik Sanatlar                                           ");
        arrayListBolum.add("Cam                                                        ");
        arrayListBolum.add("Canland??rma Filmi Tasar??m Ve Y??netimi                      ");
        arrayListBolum.add("??ini                                                       ");
        arrayListBolum.add("??ini Tasar??m??                                              ");
        arrayListBolum.add("??izgi Film Ve Animasyon                                    ");
        arrayListBolum.add("Dramatik Yazarl??k                                          ");
        arrayListBolum.add("Dramatik Yazarl??k-Dramaturji                               ");
        arrayListBolum.add("Duysal (Ses) Sanatlar?? Tasar??m??                            ");
        arrayListBolum.add("El Sanatlar??                                               ");
        arrayListBolum.add("El Sanatlar?? Tasar??m?? Ve ??retimi                           ");
        arrayListBolum.add("Eski ??ini Onar??mlar??                                       ");
        arrayListBolum.add("Film Tasar??m Ve Yazarl??k                                   ");
        arrayListBolum.add("Film Tasar??m Ve Y??netmenli??i                               ");
        arrayListBolum.add("Film Tasar??m??                                              ");
        arrayListBolum.add("Foto??raf                                                   ");
        arrayListBolum.add("Foto??raf Ve Grafik Sanatlar                                ");
        arrayListBolum.add("Foto??raf Ve Video                                          ");
        arrayListBolum.add("Geleneksel T??rk El Sanatlar??                               ");
        arrayListBolum.add("Geleneksel T??rk Sanatlar??                                  ");
        arrayListBolum.add("G??rsel ??leti??im                                            ");
        arrayListBolum.add("G??rsel ??leti??im Tasar??m??                                   ");
        arrayListBolum.add("G??rsel Sanatlar                                            ");
        arrayListBolum.add("G??rsel Sanatlar Ve G??rsel ??leti??im Tasar??m??                ");
        arrayListBolum.add("G??r??nt?? Sanatlar??                                          ");
        arrayListBolum.add("Grafik                                                     ");
        arrayListBolum.add("Grafik Resimleme Ve Bask??                                  ");
        arrayListBolum.add("Grafik Sanatlar??                                           ");
        arrayListBolum.add("Grafik Tasar??m                                             ");
        arrayListBolum.add("Hal?? Kilim                                                 ");
        arrayListBolum.add("Hal??, Kilim Ve Eski Kuma?? Desenleri                        ");
        arrayListBolum.add("Hat                                                        ");
        arrayListBolum.add("Heykel                                                     ");
        arrayListBolum.add("??leti??im Sanatlar??                                         ");
        arrayListBolum.add("??leti??im Tasar??m?? Ve Y??netimi                              ");
        arrayListBolum.add("??leti??im Ve Tasar??m                                        ");
        arrayListBolum.add("Kurgu-Ses Ve G??r??nt?? Y??netimi                              ");
        arrayListBolum.add("Kuyumculuk                                                 ");
        arrayListBolum.add("Kuyumculuk Ve M??cevher Tasar??m??                            ");
        arrayListBolum.add("Medya Ve G??rsel Sanatlar                                   ");
        arrayListBolum.add("Moda Giyim Tasar??m??                                        ");
        arrayListBolum.add("Moda Tasar??m??                                              ");
        arrayListBolum.add("Moda Ve Tekstil Tasar??m??                                   ");
        arrayListBolum.add("Plastik Sanatlar                                           ");
        arrayListBolum.add("Plastik Sanatlar Ve Resim                                  ");
        arrayListBolum.add("Resim                                                      ");
        arrayListBolum.add("Resim-Bask?? Sanatlar??                                      ");
        arrayListBolum.add("Sahne Dekorlar?? Ve Kost??m??                                 ");
        arrayListBolum.add("Sahne Tasar??m??                                             ");
        arrayListBolum.add("Sahne Ve G??steri Sanatlar?? Y??netimi                        ");
        arrayListBolum.add("Sanat (Tasar??m) Y??netimi                                   ");
        arrayListBolum.add("Sanat Eserleri Konservasyonu Ve Restorasyonu               ");
        arrayListBolum.add("Sanat Tasar??m??                                             ");
        arrayListBolum.add("Sanat Ve K??lt??r Y??netimi                                   ");
        arrayListBolum.add("Sanat Ve Tasar??m                                           ");
        arrayListBolum.add("Sanat Y??netimi                                             ");
        arrayListBolum.add("Seramik                                                    ");
        arrayListBolum.add("Seramik Sanatlar??                                          ");
        arrayListBolum.add("Seramik Ve Cam                                             ");
        arrayListBolum.add("Seramik Ve Cam Tasar??m??                                    ");
        arrayListBolum.add("Tak?? Tasar??m??                                              ");
        arrayListBolum.add("Tak?? Teknolojisi Ve Tasar??m??                               ");
        arrayListBolum.add("Tekstil                                                    ");
        arrayListBolum.add("Tekstil Tasar??m                                            ");
        arrayListBolum.add("Tekstil Tasar??m?? Ve ??retimi                                ");
        arrayListBolum.add("Tekstil Ve Deri Moda Tasar??m??                              ");
        arrayListBolum.add("Tekstil Ve Moda Tasar??m??                                   ");
        arrayListBolum.add("Tezhip                                                     ");
        arrayListBolum.add("Geomatik M??hendisli??i                                      ");
        arrayListBolum.add("Harita M??hendisli??i                                        ");
        arrayListBolum.add("Jeodezi Ve Fotogrametri M??hendisli??i                       ");
        arrayListBolum.add("Ebelik                                                     ");
        arrayListBolum.add("Hem??irelik                                                 ");
        arrayListBolum.add("Hem??irelik Ve Sa??l??k Hizmetleri                            ");
        arrayListBolum.add("Hukuk                                                      ");
        arrayListBolum.add("???? Mimarl??k                                                ");
        arrayListBolum.add("???? Mimarl??k Ve ??evre Tasar??m??                              ");
        arrayListBolum.add("Ekonomi                                                    ");
        arrayListBolum.add("Ekonomi Ve Finans                                          ");
        arrayListBolum.add("??ktisat                                                    ");
        arrayListBolum.add("????letme-Ekonomi                                            ");
        arrayListBolum.add("Animasyon                                                  ");
        arrayListBolum.add("Bas??n Ve Yay??n                                             ");
        arrayListBolum.add("Gazetecilik                                                ");
        arrayListBolum.add("Halkla ??li??kiler                                           ");
        arrayListBolum.add("Halkla ??li??kiler Ve Reklamc??l??k                            ");
        arrayListBolum.add("Halkla ??li??kiler Ve Tan??t??m                                ");
        arrayListBolum.add("??leti??im                                                   ");
        arrayListBolum.add("??leti??im Bilimleri                                         ");
        arrayListBolum.add("K??lt??r Y??netimi                                            ");
        arrayListBolum.add("Medya Ve ??leti??im                                          ");
        arrayListBolum.add("Medya Ve ??leti??im Sistemleri                               ");
        arrayListBolum.add("Moda Ve Tekstil Tasar??m??                                   ");
        arrayListBolum.add("Radyo Ve Televizyon                                        ");
        arrayListBolum.add("Radyo, Televizyon Ve Sinema                                ");
        arrayListBolum.add("Reklam Tasar??m?? Ve ??leti??imi                               ");
        arrayListBolum.add("Reklamc??l??k                                                ");
        arrayListBolum.add("Sinema Ve Dijital Medya                                    ");
        arrayListBolum.add("Sinema Ve Televizyon                                       ");
        arrayListBolum.add("Televizyon Habercili??i Ve Programc??l??????                    ");
        arrayListBolum.add("Turizm Animasyonu                                          ");
        arrayListBolum.add("Yeni Medya                                                 ");
        arrayListBolum.add("Yeni Medya Ve Gazetecilik                                  ");
        arrayListBolum.add("??malat M??hendisli??i                                        ");
        arrayListBolum.add("Kontrol M??hendisli??i                                       ");
        arrayListBolum.add("Kontrol Ve Otomasyon M??hendisli??i                          ");
        arrayListBolum.add("Makine Ve ??malat M??hendisli??i                              ");
        arrayListBolum.add("Mekatronik M??hendisli??i                                    ");
        arrayListBolum.add("Mekatronik Sistemler M??hendisli??i                          ");
        arrayListBolum.add("??retim Sistemleri M??hendisli??i                             ");
        arrayListBolum.add("??n??aat M??hendisli??i                                        ");
        arrayListBolum.add("D??nya Dinleri                                              ");
        arrayListBolum.add("??lahiyat                                                   ");
        arrayListBolum.add("??slam Ve Din Bilimleri                                     ");
        arrayListBolum.add("??slami ??limler                                             ");
        arrayListBolum.add("Uluslararas?? ??lahiyat                                      ");
        arrayListBolum.add("Yayg??n Din ????retimi Ve Uygulamalar??                        ");
        arrayListBolum.add("Akt??erya                                                   ");
        arrayListBolum.add("Akt??erya Bilimleri                                         ");
        arrayListBolum.add("Akt??erya Ve Risk Y??netimi                                  ");
        arrayListBolum.add("??statistik                                                 ");
        arrayListBolum.add("??statistik Ve Bilgisayar Bilimleri                         ");
        arrayListBolum.add("????letme                                                    ");
        arrayListBolum.add("Y??netim Bilimleri (????letme Fak??ltesi)                      ");
        arrayListBolum.add("Y??netim Bilimleri Programlar??                              ");
        arrayListBolum.add("Jeofizik M??hendisli??i                                      ");
        arrayListBolum.add("Hidrojeoloji M??hendisli??i                                  ");
        arrayListBolum.add("Jeoloji M??hendisli??i                                       ");
        arrayListBolum.add("Kentsel Tasar??m Ve Peyzaj Mimarisi                         ");
        arrayListBolum.add("Peyzaj Mimarl??????                                           ");
        arrayListBolum.add("??ehir Ve B??lge Planlama                                    ");
        arrayListBolum.add("Kimya                                                      ");
        arrayListBolum.add("Biyokimya                                                  ");
        arrayListBolum.add("Kimya M??hendisli??i                                         ");
        arrayListBolum.add("Kimya M??hendisli??i Ve Uygulamal?? Kimya                     ");
        arrayListBolum.add("Kimya Ve S??re?? M??hendisli??i                                ");
        arrayListBolum.add("Kimya-Biyoloji M??hendisli??i                                ");
        arrayListBolum.add("Polimer M??hendisli??i                                       ");
        arrayListBolum.add("Arp                                                        ");
        arrayListBolum.add("Bale                                                       ");
        arrayListBolum.add("Bale Dans????l??????                                            ");
        arrayListBolum.add("Bando ??efli??i                                              ");
        arrayListBolum.add("Caz                                                        ");
        arrayListBolum.add("??alg??                                                      ");
        arrayListBolum.add("??alg?? E??itimi                                              ");
        arrayListBolum.add("??alg?? Yap??m                                                ");
        arrayListBolum.add("Dans                                                       ");
        arrayListBolum.add("Drama Ve Oyunculuk                                         ");
        arrayListBolum.add("Fagot                                                      ");
        arrayListBolum.add("Fl??t                                                       ");
        arrayListBolum.add("Geleneksel T??rk M??zikleri                                  ");
        arrayListBolum.add("Genel M??zikoloji                                           ");
        arrayListBolum.add("Gitar                                                      ");
        arrayListBolum.add("Keman                                                      ");
        arrayListBolum.add("Klarnet                                                    ");
        arrayListBolum.add("Klasik Bale                                                ");
        arrayListBolum.add("Kompozisyon                                                ");
        arrayListBolum.add("Kompozisyon(Bestecilik)                                    ");
        arrayListBolum.add("Kompozisyon Ve Orkestra ??efli??i                            ");
        arrayListBolum.add("Kontrabas                                                  ");
        arrayListBolum.add("Korno                                                      ");
        arrayListBolum.add("Koro                                                       ");
        arrayListBolum.add("Modern Dans                                                ");
        arrayListBolum.add("M??zik                                                      ");
        arrayListBolum.add("M??zik Bilimleri                                            ");
        arrayListBolum.add("M??zik Teknolosi                                            ");
        arrayListBolum.add("M??zik Teorisi                                              ");
        arrayListBolum.add("M??zik Topluluklar??                                         ");
        arrayListBolum.add("M??zikoloji                                                 ");
        arrayListBolum.add("Nefesli ??alg??lar Ve Vurmal?? ??alg??lar                       ");
        arrayListBolum.add("Obua                                                       ");
        arrayListBolum.add("Opera                                                      ");
        arrayListBolum.add("Opera ??ark??c??l??????                                          ");
        arrayListBolum.add("Opera Ve Konser ??ark??c??l??????                                ");
        arrayListBolum.add("Osmanl?? D??nemi Kar????la??t??rmal?? M??zik                       ");
        arrayListBolum.add("Oyunculuk                                                  ");
        arrayListBolum.add("Piyano                                                     ");
        arrayListBolum.add("Piyano Onar??m?? Yap??m??                                      ");
        arrayListBolum.add("Piyano-Arp-Gitar                                           ");
        arrayListBolum.add("Pop??ler M??zik ??ark??c??l??????                                  ");
        arrayListBolum.add("Sahne Sanatlar??                                            ");
        arrayListBolum.add("Ses E??itimi                                                ");
        arrayListBolum.add("??an                                                        ");
        arrayListBolum.add("Temel Bilimler                                             ");
        arrayListBolum.add("Teori                                                      ");
        arrayListBolum.add("Tiyatro                                                    ");
        arrayListBolum.add("Tiyatro Ele??tirmenli??i Ve Dramaturji                       ");
        arrayListBolum.add("Trombon                                                    ");
        arrayListBolum.add("Trompet                                                    ");
        arrayListBolum.add("Tuba                                                       ");
        arrayListBolum.add("T??rk Din Musikisi                                          ");
        arrayListBolum.add("T??rk Halk M??zi??i                                           ");
        arrayListBolum.add("T??rk Halk M??zi??i ??alg?? E??itimi                             ");
        arrayListBolum.add("T??rk Halk M??zi??i Ses E??itimi                               ");
        arrayListBolum.add("T??rk Halk Oyunlar??                                         ");
        arrayListBolum.add("T??rk Musikisi                                              ");
        arrayListBolum.add("T??rk Musikisi Temel Bilimler                               ");
        arrayListBolum.add("T??rk M??zi??i                                                ");
        arrayListBolum.add("T??rk Sanat M??zi??i                                          ");
        arrayListBolum.add("T??rk Sanat M??zi??i Ses E??itimi                              ");
        arrayListBolum.add("T??rk Sanat M??zi??i Temel Bilimler                           ");
        arrayListBolum.add("??flemeli Ve Vurmal?? ??alg??lar                               ");
        arrayListBolum.add("Viyola                                                     ");
        arrayListBolum.add("Viyolonsel                                                 ");
        arrayListBolum.add("Vurmal?? ??alg??lar                                           ");
        arrayListBolum.add("Yayl?? ??alg??lar                                             ");
        arrayListBolum.add("Yayl?? ??alg??lar Yap??m??                                      ");
        arrayListBolum.add("Cevher Haz??rlama M??hendisli??i                              ");
        arrayListBolum.add("Maden M??hendisli??i                                         ");
        arrayListBolum.add("Makine M??hendisli??i                                        ");
        arrayListBolum.add("Maliye                                                     ");
        arrayListBolum.add("Malzeme Bilimi Ve M??hendisli??i                             ");
        arrayListBolum.add("Malzeme Bilimi Ve Nano M??hendislik                         ");
        arrayListBolum.add("Malzeme Bilimi Ve Nanoteknoloji M??hendisli??i               ");
        arrayListBolum.add("Malzeme M??hendisli??i                                       ");
        arrayListBolum.add("Metalurji Ve Malzeme M??hendisli??i                          ");
        arrayListBolum.add("Finans Matemati??i                                          ");
        arrayListBolum.add("Matematik                                                  ");
        arrayListBolum.add("Matematik M??hendisli??i                                     ");
        arrayListBolum.add("Matematik Ve Bilgisayar Bilimleri                          ");
        arrayListBolum.add("Matematik-Bilgisayar                                       ");
        arrayListBolum.add("Gemi Ve Yat Tasar??m??                                       ");
        arrayListBolum.add("Mimarl??k                                                   ");
        arrayListBolum.add("Odyoloji                                                   ");
        arrayListBolum.add("Otomotiv M??hendisli??i                                      ");
        arrayListBolum.add("Rayl?? Sistemler M??hendisli??i                               ");
        arrayListBolum.add("Ula??t??rma M??hendisli??i                                     ");
        arrayListBolum.add("Aile Ekonomisi Ve Beslenme ????retmenli??i                    ");
        arrayListBolum.add("Aile Ve T??ketici Bilimleri ????retmenli??i                    ");
        arrayListBolum.add("Almanca ????retmenli??i                                       ");
        arrayListBolum.add("Arap??a ????retmenli??i                                        ");
        arrayListBolum.add("Beden E??itimi Ve Spor ????retmenli??i                         ");
        arrayListBolum.add("Bilgisayar ????retmenli??i                                    ");
        arrayListBolum.add("Bilgisayar Sistemleri ????retmenli??i                         ");
        arrayListBolum.add("Bilgisayar Ve Kontrol ????retmenli??i                         ");
        arrayListBolum.add("Bilgisayar Ve ????retim Teknolojileri ????retmenli??i           ");
        arrayListBolum.add("Biyoloji ????retmenli??i                                      ");
        arrayListBolum.add("B??ro Y??netimi ????retmenli??i                                 ");
        arrayListBolum.add("Co??rafya ????retmenli??i                                      ");
        arrayListBolum.add("??i??ek, ??rg?? Ve Dokuma ????retmenli??i                         ");
        arrayListBolum.add("??ocuk Geli??imi Ve Okul ??ncesi ????retmenli??i                 ");
        arrayListBolum.add("Dekoratif Sanatlar ????retmenli??i                            ");
        arrayListBolum.add("Din K??lt??r?? Ve Ahlak Bilgisi ????retmenli??i                  ");
        arrayListBolum.add("D??k??m ????retmenli??i                                         ");
        arrayListBolum.add("Elektrik ????retmenli??i                                      ");
        arrayListBolum.add("Elektronik ????retmenli??i                                    ");
        arrayListBolum.add("Elektronik Ve Bilgisayar ????retmenli??i                      ");
        arrayListBolum.add("Elektronik Ve Haberle??me ????retmenli??i                      ");
        arrayListBolum.add("End??striyel Teknoloji ????retmenli??i                         ");
        arrayListBolum.add("Enerji ????retmenli??i                                        ");
        arrayListBolum.add("Engellilerde Beden E??itimi Ve Spor ????retmenli??i            ");
        arrayListBolum.add("Felsefe Grubu ????retmenli??i                                 ");
        arrayListBolum.add("Fen Bilgisi ????retmenli??i                                   ");
        arrayListBolum.add("Fizik ????retmenli??i                                         ");
        arrayListBolum.add("Frans??zca ????retmenli??i                                     ");
        arrayListBolum.add("Giyim End??strisi ????retmenli??i                              ");
        arrayListBolum.add("Giyim ????retmenli??i                                         ");
        arrayListBolum.add("G??rme Engelliler ????retmenli??i                              ");
        arrayListBolum.add("Grafik ????retmenli??i                                        ");
        arrayListBolum.add("Haz??r Giyim ????retmenli??i                                   ");
        arrayListBolum.add("??lk????retim Din K??lt??r?? Ve Ahlak Bilgisi ????retmenli??i       ");
        arrayListBolum.add("??lk????retim Matematik ????retmenli??i                          ");
        arrayListBolum.add("??ngilizce ????retmenli??i                                     ");
        arrayListBolum.add("??ngilizce ????retmenli??i ????retimi                            ");
        arrayListBolum.add("????itme Engelliler ????retmenli??i                             ");
        arrayListBolum.add("????letme ????retmenli??i                                       ");
        arrayListBolum.add("Japonca ????retmenli??i                                       ");
        arrayListBolum.add("Kal??p????l??k ????retmenli??i                                    ");
        arrayListBolum.add("Kimya ????retmenli??i                                         ");
        arrayListBolum.add("Konaklama ????letmecili??i E??itimi                            ");
        arrayListBolum.add("Konaklama ????letmecili??i ????retmenli??i                       ");
        arrayListBolum.add("Kontrol ????retmenli??i                                       ");
        arrayListBolum.add("Kuaf??rl??k Ve G??zellik Bilgisi ????retmenli??i                 ");
        arrayListBolum.add("Makine Resim Ve Konstr??ksiyonu ????retmenli??i                ");
        arrayListBolum.add("Matbaa ????retmenli??i                                        ");
        arrayListBolum.add("Matematik ????retmenli??i                                     ");
        arrayListBolum.add("Mekatronik ????retmenli??i                                    ");
        arrayListBolum.add("Mesleki Resim ????retmenli??i                                 ");
        arrayListBolum.add("Metal ????retmenli??i                                         ");
        arrayListBolum.add("Mobilya Ve Dekorasyon ????retmenli??i                         ");
        arrayListBolum.add("Moda Tasar??m?? ????retmenli??i                                 ");
        arrayListBolum.add("Muhasebe Ve Finansman ????retmenli??i                         ");
        arrayListBolum.add("M??zik ????retmenli??i                                         ");
        arrayListBolum.add("Nak???? ????retmenli??i                                         ");
        arrayListBolum.add("Okul ??ncesi ????retmenli??i                                   ");
        arrayListBolum.add("Otomotiv ????retmenli??i                                      ");
        arrayListBolum.add("??zel E??itim ????retmenli??i                                   ");
        arrayListBolum.add("Pazarlama ????retmenli??i                                     ");
        arrayListBolum.add("Resim-???? E??itimi                                           ");
        arrayListBolum.add("Resim-???? ????retmenli??i                                      ");
        arrayListBolum.add("Sa??l??k E??itimi                                             ");
        arrayListBolum.add("Seramik ????retmenli??i                                       ");
        arrayListBolum.add("Seyahat ????letmecili??i Ve Turizm Rehberli??i E??itimi         ");
        arrayListBolum.add("Seyahat ????letmecili??i Ve Turizm Rehberli??i ????retmenli??i    ");
        arrayListBolum.add("S??n??f ????retmenli??i                                         ");
        arrayListBolum.add("Sosyal Bilgiler ????retmenli??i                               ");
        arrayListBolum.add("Tala??l?? ??retim ????retmenli??i                                ");
        arrayListBolum.add("Tarih ????retmenli??i                                         ");
        arrayListBolum.add("Tasar??m Ve Konstr??ksiyon ????retmenli??i                      ");
        arrayListBolum.add("Tekstil Dokuma Ve ??rg?? ????retmenli??i                        ");
        arrayListBolum.add("Tekstil ????retmenli??i                                       ");
        arrayListBolum.add("Tekstil Terbiye ????retmenli??i                               ");
        arrayListBolum.add("Telekom??nikasyon ????retmenli??i                              ");
        arrayListBolum.add("Tesisat ????retmenli??i                                       ");
        arrayListBolum.add("T??rk Dili Ve Edebiyat?? ????retmenli??i                        ");
        arrayListBolum.add("T??rk??e ????retmenli??i                                        ");
        arrayListBolum.add("T??rk??e ????retmenli??i ????retim                                ");
        arrayListBolum.add("??st??n Zek??l??lar ????retmenli??i                               ");
        arrayListBolum.add("Yap?? ????retmenli??i                                          ");
        arrayListBolum.add("Yap?? Ressaml?????? ????retmenli??i                               ");
        arrayListBolum.add("Yap?? Tasar??m?? ????retmenli??i                                 ");
        arrayListBolum.add("Zihin Engelliler ????retmenli??i                              ");
        arrayListBolum.add("Enerji Sistemleri M??hendisli??i                             ");
        arrayListBolum.add("N??kleer Enerji M??hendisli??i                                ");
        arrayListBolum.add("Petrol Ve Do??algaz M??hendisli??i                            ");
        arrayListBolum.add("Pilotaj                                                    ");
        arrayListBolum.add("Pilot E??itimi                                              ");
        arrayListBolum.add("Psikoloji                                                  ");
        arrayListBolum.add("??ocuk Geli??imi                                             ");
        arrayListBolum.add("??ocuk Sa??l?????? Ve Geli??imi Rehberlik (Pdr)                  ");
        arrayListBolum.add("Rehberlik Ve Psikolojik Dan????manl??k                        ");
        arrayListBolum.add("Acil Yard??m Ve Afet Y??netimi                               ");
        arrayListBolum.add("Dil Ve Konu??ma Terapisi                                    ");
        arrayListBolum.add("Gerontoloj                                                 ");
        arrayListBolum.add("Ortez-Protez                                               ");
        arrayListBolum.add("Perf??zyon                                                  ");
        arrayListBolum.add("Sa??l??k ??daresi                                             ");
        arrayListBolum.add("Sa??l??k Kurumlar?? ????letmecili??i                             ");
        arrayListBolum.add("Sa??l??k Kurumlar?? Y??neticili??i                              ");
        arrayListBolum.add("Sa??l??k Kurumlar?? Y??netimi                                  ");
        arrayListBolum.add("Sa??l??k Memurlu??u                                           ");
        arrayListBolum.add("Sa??l??k Y??netimi                                            ");
        arrayListBolum.add("Avrupa Birli??i ??li??kileri                                  ");
        arrayListBolum.add("Kamu Y??netimi                                              ");
        arrayListBolum.add("K??resel Siyaset Ve Uluslararas?? ??li??kiler                  ");
        arrayListBolum.add("K??resel Ve Uluslararas?? ??li??kiler                          ");
        arrayListBolum.add("Siyaset Bilimi                                             ");
        arrayListBolum.add("Siyaset Bilimi Ve Kamu Y??netimi                            ");
        arrayListBolum.add("Siyaset Bilimi Ve Uluslararas?? ??li??kiler                   ");
        arrayListBolum.add("Toplumsal Ve Siyasal Bilimler                              ");
        arrayListBolum.add("Uluslararas?? ??al????malar                                    ");
        arrayListBolum.add("Uluslararas?? ??li??kiler                                     ");
        arrayListBolum.add("Uluslararas?? ??li??kiler Ve Avrupa Birli??i                   ");
        arrayListBolum.add("Uluslararas?? ??li??kiler Ve Deniz G??venli??i                  ");
        arrayListBolum.add("Sosyal Hizmetler                                           ");
        arrayListBolum.add("??nsan Ve Toplum Bilimleri                                  ");
        arrayListBolum.add("K??lt??rel ??al????malar                                        ");
        arrayListBolum.add("Sosyoloji                                                  ");
        arrayListBolum.add("Antren??rl??k E??itimi                                        ");
        arrayListBolum.add("Rekreasyon                                                 ");
        arrayListBolum.add("Rekreasyon Y??netimi                                        ");
        arrayListBolum.add("Spor Bilimleri                                             ");
        arrayListBolum.add("Spor Y??neticili??i                                          ");
        arrayListBolum.add("Bal??k????l??k Teknolojisi                                     ");
        arrayListBolum.add("Bal??k????l??k Teknolojisi M??hendisli??i                        ");
        arrayListBolum.add("Su Bilimleri Ve M??hendisli??i                               ");
        arrayListBolum.add("Su ??r??nleri                                                ");
        arrayListBolum.add("Bilim Tarihi                                               ");
        arrayListBolum.add("Sanat Tarihi                                               ");
        arrayListBolum.add("Tarih                                                      ");
        arrayListBolum.add("A??a?? ????leri End??stri M??hendisli??i                          ");
        arrayListBolum.add("Aile Ve T??ketici Bilimleri                                 ");
        arrayListBolum.add("Bas??m Teknolojileri                                        ");
        arrayListBolum.add("Besin Teknolojisi                                          ");
        arrayListBolum.add("Bilgi Ve Belge Y??netimi                                    ");
        arrayListBolum.add("Bilgisayar Bilimleri                                       ");
        arrayListBolum.add("Bilgisayar Teknolojisi Ve Bili??im Sistemleri               ");
        arrayListBolum.add("Bili??im Sistemleri Ve Teknolojileri                        ");
        arrayListBolum.add("Denizcilik ????letmeleri Y??netimi                            ");
        arrayListBolum.add("Enformasyon Teknolojileri                                  ");
        arrayListBolum.add("Ev Ekonomisi                                               ");
        arrayListBolum.add("Gayrimenkul Ve Varl??k De??erleme                            ");
        arrayListBolum.add("G??da Teknolojisi                                           ");
        arrayListBolum.add("Giri??imcilik                                               ");
        arrayListBolum.add("G??mr??k ????letme                                             ");
        arrayListBolum.add("Hava Trafik Kontrol                                        ");
        arrayListBolum.add("Havac??l??k Elektrik Ve Elektroni??i                          ");
        arrayListBolum.add("Havac??l??k ????letmecili??i                                    ");
        arrayListBolum.add("Havac??l??k Y??netimi                                         ");
        arrayListBolum.add("??nsan Kaynaklar?? Y??netimi                                  ");
        arrayListBolum.add("???? Sa??l?????? Ve G??venli??i                                    ");
        arrayListBolum.add("????letme Bilgi Y??netimi                                     ");
        arrayListBolum.add("????letme Enformati??i                                        ");
        arrayListBolum.add("????letme Y??netimi                                           ");
        arrayListBolum.add("K??t??phanecilik                                             ");
        arrayListBolum.add("Lojistik                                                   ");
        arrayListBolum.add("Lojistik Y??netimi                                          ");
        arrayListBolum.add("Muhasebe                                                   ");
        arrayListBolum.add("Muhasebe Bilgi Sistemleri                                  ");
        arrayListBolum.add("Muhasebe Ve Denetim                                        ");
        arrayListBolum.add("Muhasebe Ve Finansal Y??netim                               ");
        arrayListBolum.add("Mutfak Sanatlar?? Ve Y??netimi                               ");
        arrayListBolum.add("Pazarlama                                                  ");
        arrayListBolum.add("Sivil Hava Ula??t??rma ????letmecili??i                         ");
        arrayListBolum.add("Sivil Havac??l??k ????letmecili??i                              ");
        arrayListBolum.add("Tapu Kadastro                                              ");
        arrayListBolum.add("Teknoloji Ve Bilgi Y??netimi                                ");
        arrayListBolum.add("Tekstil Geli??tirme Ve Pazarlama                            ");
        arrayListBolum.add("U??ak Elektrik-Elektronik                                   ");
        arrayListBolum.add("U??ak G??vde-Motor                                           ");
        arrayListBolum.add("U??ak G??vde-Motor Bak??m??                                    ");
        arrayListBolum.add("Y??netim Bilimleri                                          ");
        arrayListBolum.add("Y??netim Bili??im Sistemleri                                 ");
        arrayListBolum.add("Deri M??hendisli??i                                          ");
        arrayListBolum.add("Tekstil M??hendisli??i                                       ");
        arrayListBolum.add("T??p                                                        ");
        arrayListBolum.add("Gastronomi                                                 ");
        arrayListBolum.add("Gastronomi Ve Mutfak Sanatlar??                             ");
        arrayListBolum.add("Konaklama ????letmecili??i                                    ");
        arrayListBolum.add("Otel Y??neticili??i                                          ");
        arrayListBolum.add("Seyahat ????letmecili??i                                      ");
        arrayListBolum.add("Seyahat ????letmecili??i Ve Turizm Rehberli??i                 ");
        arrayListBolum.add("Turizm ????letmecili??i                                       ");
        arrayListBolum.add("Turizm ????letmecili??i Ve Otelcilik                          ");
        arrayListBolum.add("Turizm Rehberli??i                                          ");
        arrayListBolum.add("Turizm Ve Otel ????letmecili??i                               ");
        arrayListBolum.add("Turizm Ve Otelcilik                                        ");
        arrayListBolum.add("Yiyecek Ve ????ecek ????letmecili??i                            ");
        arrayListBolum.add("T??rk Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Havac??l??k Ve Uzay M??hendisli??i                             ");
        arrayListBolum.add("Meteoroloji M??hendisli??i                                   ");
        arrayListBolum.add("U??ak M??hendisli??i                                          ");
        arrayListBolum.add("Uzay M??hendisli??i                                          ");
        arrayListBolum.add("Ula??t??rma Ve Lojistik                                      ");
        arrayListBolum.add("Uluslararas?? Finans                                        ");
        arrayListBolum.add("Uluslararas?? Finans Ve Bankac??l??k                          ");
        arrayListBolum.add("Uluslararas?? Giri??imcilik                                  ");
        arrayListBolum.add("Uluslararas?? ????letme Y??netimi                              ");
        arrayListBolum.add("Uluslararas?? ????letmecilik                                  ");
        arrayListBolum.add("Uluslararas?? Lojistik                                      ");
        arrayListBolum.add("Uluslararas?? Lojistik Ve Ta????mac??l??k                       ");
        arrayListBolum.add("Uluslararas?? Lojistik Y??netimi                             ");
        arrayListBolum.add("Uluslararas?? Ticaret                                       ");
        arrayListBolum.add("Uluslararas?? Ticaret Ve Finans                             ");
        arrayListBolum.add("Uluslararas?? Ticaret Ve Finansman                          ");
        arrayListBolum.add("Uluslararas?? Ticaret Ve ????letmecilik                       ");
        arrayListBolum.add("Uluslararas?? Ticaret Ve Lojistik                           ");
        arrayListBolum.add("Uluslararas?? Ticaret Ve Lojistik Y??netimi                  ");
        arrayListBolum.add("Uluslararas?? Ticaret Ve Pazarlama                          ");
        arrayListBolum.add("Uluslararas?? Ticaret, Lojistik Ve ????letmecilik             ");
        arrayListBolum.add("Veterinerlik                                               ");
        arrayListBolum.add("Alman Dili Ve Edebiyat??                                    ");
        arrayListBolum.add("Amerikan K??lt??r?? Ve Edebiyat??                              ");
        arrayListBolum.add("Arap Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Arnavut Dili Ve Edebiyat??                                  ");
        arrayListBolum.add("Azerbaycan T??rk??esi Ve Edebiyat??                           ");
        arrayListBolum.add("Bo??nak Dili Ve Edebiyat??                                   ");
        arrayListBolum.add("Bulgar Dili Ve Edebiyat??                                   ");
        arrayListBolum.add("??a??da?? T??rk Leh??eleri Ve Edebiyatlar??                      ");
        arrayListBolum.add("??a??da?? Yunan Dili Ve Edebiyat??                             ");
        arrayListBolum.add("??erkez Dili Ve Edebiyat??                                   ");
        arrayListBolum.add("??eviribilim (Almanca)                                      ");
        arrayListBolum.add("??eviribilim (??ngilizce)                                    ");
        arrayListBolum.add("??in Dili Ve Edebiyat??                                      ");
        arrayListBolum.add("Dilbilim                                                   ");
        arrayListBolum.add("Ermeni Dili Ve Edebiyat??                                   ");
        arrayListBolum.add("Eski Yunan Dili Ve Edebiyat??                               ");
        arrayListBolum.add("Fars Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Frans??z Dili Ve Edebiyat??                                  ");
        arrayListBolum.add("G??rc?? Dili Ve Edebiyat??                                    ");
        arrayListBolum.add("H??rvat Dili Ve Edebiyat??                                   ");
        arrayListBolum.add("Hindoloji                                                  ");
        arrayListBolum.add("Hititoloji                                                 ");
        arrayListBolum.add("Hungaroloji                                                ");
        arrayListBolum.add("??brani Dili Ve Edebiyat??                                   ");
        arrayListBolum.add("??ngiliz Dil Bilimi                                         ");
        arrayListBolum.add("??ngiliz Dili Ve Edebiyat??                                  ");
        arrayListBolum.add("??ngiliz Dili Ve Kar????la??t??rmal?? Edebiyat                   ");
        arrayListBolum.add("??spanyol Dili Ve Edebiyat??                                 ");
        arrayListBolum.add("??talyan Dili Ve Edebiyat??                                  ");
        arrayListBolum.add("Japon Dili Ve Edebiyat??                                    ");
        arrayListBolum.add("Kar????la??t??rmal?? Edebiyat                                   ");
        arrayListBolum.add("Kar????la??t??rmal?? Edebiyat (??ngilizce)                       ");
        arrayListBolum.add("Kore Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Koreoloji                                                  ");
        arrayListBolum.add("K??rt Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Latin Dili Ve Edebiyat??                                    ");
        arrayListBolum.add("Leh Dili Ve Edebiyat??                                      ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Frans??zca)                           ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Almanca)                             ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Arap??a)                              ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Bulgarca)                            ");
        arrayListBolum.add("M??tercim-Terc??manl??k (??ift Dilli: ??ngilizce-Almanca)       ");
        arrayListBolum.add("M??tercim-Terc??manl??k (??ift Dilli: ??ngilizce-Frans??zca)     ");
        arrayListBolum.add("M??tercim-Terc??manl??k (??ince)                               ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Fars??a)                              ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Frans??zca)                           ");
        arrayListBolum.add("M??tercim-Terc??manl??k (??ngilizce)                           ");
        arrayListBolum.add("M??tercim-Terc??manl??k (Rus??a)                               ");
        arrayListBolum.add("M??tercim-Terc??manl??k (T??rk??e-??ngilizce-Frans??zca)          ");
        arrayListBolum.add("M??tercim-Terc??manl??k (T??rk??e-Almanca-??ngilizce)            ");
        arrayListBolum.add("Polonya Dili Ve K??lt??r?? (Leh??e)                            ");
        arrayListBolum.add("Rus Dili Ve Edebiyat??                                      ");
        arrayListBolum.add("Sinoloji                                                   ");
        arrayListBolum.add("S??meroloji                                                 ");
        arrayListBolum.add("Urdu Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Yunan Dili Ve Edebiyat??                                    ");
        arrayListBolum.add("Zaza Dili Ve Edebiyat??                                     ");
        arrayListBolum.add("Bah??e Bitkileri                                            ");
        arrayListBolum.add("Bitki Koruma                                               ");
        arrayListBolum.add("Bitkisel ??retim                                            ");
        arrayListBolum.add("Bitkisel ??retim Ve Teknolojileri                           ");
        arrayListBolum.add("Hayvansal ??retim                                           ");
        arrayListBolum.add("Organik Tar??m ????letmecili??i                                ");
        arrayListBolum.add("Orman End??strisi M??hendisli??i                              ");
        arrayListBolum.add("Orman M??hendisli??i                                         ");
        arrayListBolum.add("Performans                                                 ");
        arrayListBolum.add("S??t Teknolojisi                                            ");
        arrayListBolum.add("Tar??m Ekonomisi                                            ");
        arrayListBolum.add("Tar??m Makineleri                                           ");
        arrayListBolum.add("Tar??m Teknolojisi                                          ");
        arrayListBolum.add("Tar??msal Biyoteknoloji                                     ");
        arrayListBolum.add("Tar??msal Genetik M??hendisli??i                              ");
        arrayListBolum.add("Tar??msal Yap??lar Ve Sulama                                 ");
        arrayListBolum.add("Tarla Bitkileri                                            ");
        arrayListBolum.add("Toprak                                                     ");
        arrayListBolum.add("Toprak Bilimi Ve Bitki Besleme                             ");
        arrayListBolum.add("T??t??n Eksperli??i Y??ksekokulu                               ");
        arrayListBolum.add("Yaban Hayat?? Ekolojisi Ve Y??netimi                         ");
        arrayListBolum.add("Zeotekni                                                   ");
        arrayListBolum.add("Ziraat M??hendisli??i                                        ");
        arrayListBolum.add("Zootekni                                                   ");


        textViewBolum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBolum = new Dialog(getActivity());
                dialogBolum.setContentView(R.layout.dialog_searchable_spinner_bolum);
                dialogBolum.getWindow().setLayout(900, 1500);
                dialogBolum.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogBolum.show();

                EditText editTextBolum = dialogBolum.findViewById(R.id.edit_text_bolum);
                ListView listViewBolum = dialogBolum.findViewById(R.id.list_view_bolum);

                ArrayAdapter<String> adapterBolum = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListBolum);
                listViewBolum.setAdapter(adapterBolum);

                editTextBolum.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapterBolum.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listViewBolum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textViewBolum.setText(adapterBolum.getItem(i));
                        dialogBolum.dismiss();
                    }
                });

            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                dialog.getWindow().setLayout(900, 1500);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayList);
                listView.setAdapter(adapter);

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setText(adapter.getItem(i));
                        dialog.dismiss();
                    }
                });

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                    int radioId = radioGroup.getCheckedRadioButtonId();
                    radioButton = view.findViewById(radioId);
                    Toast.makeText(getContext(), "Se??iminiz: " + radioButton.getText() , Toast.LENGTH_SHORT).show();
                }
        });

        view.findViewById(R.id.buttonSaver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth = FirebaseAuth.getInstance();
                String userEmail = mAuth.getCurrentUser().getUid();
                String uniIsmi = textView.getText().toString().toLowerCase();
                String capitalizedUniIsmi =  StringUtils.capitalize(uniIsmi);

                //textView.getText().toString() + "-" + textViewBolum.getText().toString().toUpperCase(Locale.ROOT) + " B??l??m??"

                if(!textView.getText().toString().equals("-----DEVLET ??N??VERS??TELER??-----")
                        && !textView.getText().toString().equals("-----VAKIF ??N??VERS??TELER??-----")
                        && !textView.getText().toString().equals("-----KKTC ??N??VERS??TELER??-----")
                        && !textView.getText().toString().equals("-----YURT DI??I ??N??VERS??TELER??-----")
                        && !textView.getText().toString().equals("")){
                    if(!personName.getText().toString().equals("")) {
                        if (radioGroup.getCheckedRadioButtonId() != -1) {
                            if (!textViewBolum.getText().toString().equals("")) {
                                    //sharedPreferences.edit().putInt("y", 1).apply();
                                databaseReference.child(userEmail).child("Name").setValue(personName.getText().toString());
                                databaseReference.child(userEmail).child("Hedef").setValue(capitalizedUniIsmi);
                                databaseReference.child(userEmail).child("Alan").setValue(radioButton.getText().toString());
                            }  else {
                                Toast.makeText(getActivity(), "L??tfen ??niversite b??l??m??n??z?? se??iniz.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "L??tfen alan??n??z?? se??iniz", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "L??tfen ad??n??z?? giriniz.", Toast.LENGTH_SHORT).show();
                    }
                }  else {
                    Toast.makeText(getActivity(), "L??tfen bir ??niversite se??iniz.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}




