package com.example.magapp;

import static com.example.magapp.function.fetchname;

import android.Manifest;
import android.app.Activity;
import android.app.AutomaticZenRule;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.camera2.CameraManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsManager;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class MainActivity extends AppCompatActivity {
    private static final Object READCONTACTS = 100;
    private static final int REQUESTCALL = 100;
    private static final int REQUEST_ENABLE_BT = 100;
    private static final int SENDSMS = 100;
    private static final int READSMS = 100;
    private SpeechRecognizer recognizer;
    private TextView tresult;
    private TextToSpeech tts;
    private static final int REQUEST_CODE = 10;
    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        initializeTextToSpeech();
        initializeResult();
    }

    private static final int REQUEST_CODE_SPEECH_INPUT = 100;


    private Object withPermission(String camera) {
        return null;
    }

    private void initializeTextToSpeech() {
        this.tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() { // from class: com.example.myapplication.MainActivity$$ExternalSyntheticLambda0
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i) {
                MainActivity.this.m40xc62cd961(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initializeTextToSpeech$0$com-example-myapplication-MainActivity  reason: not valid java name */
    public /* synthetic */ void m40xc62cd961(int i) {
        if (this.tts.getEngines().size() == 0) {
            Toast.makeText(this, "Engine is not available", Toast.LENGTH_SHORT).show();
            return;
        }
        String S = function.wishme();
        speak("Hii  .....MySelf MAG .... i am Your assistant guide " + S);
    }

    private void speak(String msg) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.tts.speak(msg, 0, null, null);
        } else {
            this.tts.speak(msg, 0, null);
        }
    }

    private void findById() {
        this.tresult = (TextView) findViewById(R.id.textView);
    }

    private void initializeResult() {
        if (SpeechRecognizer.isRecognitionAvailable(this)) {
            SpeechRecognizer createSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            this.recognizer = createSpeechRecognizer;
            createSpeechRecognizer.setRecognitionListener(new RecognitionListener() { // from class: com.example.myapplication.MainActivity.1
                @Override // android.speech.RecognitionListener
                public void onReadyForSpeech(Bundle bundle) {
                }

                @Override // android.speech.RecognitionListener
                public void onBeginningOfSpeech() {
                }

                @Override // android.speech.RecognitionListener
                public void onRmsChanged(float v) {
                }

                @Override // android.speech.RecognitionListener
                public void onBufferReceived(byte[] bytes) {
                }

                @Override // android.speech.RecognitionListener
                public void onEndOfSpeech() {
                }

                @Override // android.speech.RecognitionListener
                public void onError(int i) {
                }

                @Override // android.speech.RecognitionListener
                public void onResults(Bundle bundle) {
                    ArrayList<String> result = bundle.getStringArrayList("results_recognition");
                    Toast.makeText(MainActivity.this, "" + result.get(0), Toast.LENGTH_SHORT).show();
                    MainActivity.this.tresult.setText(result.get(0));
                    MainActivity.this.response(result.get(0));
                }

                @Override // android.speech.RecognitionListener
                public void onPartialResults(Bundle bundle) {
                }

                @Override // android.speech.RecognitionListener
                public void onEvent(int i, Bundle bundle) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void response(String msg2) {
        String msg = msg2.toLowerCase();


        if (msg.indexOf("hi") != -1) {
            speak("hello, How are You ??");

        }
        if (msg.indexOf("hi") != -1) {
            speak("hello, How are You ??");
        }
        if (msg.indexOf("hello") != -1) {
            speak("hello, How are You ??");
        }
        if (msg.indexOf("hi mag") != -1) {
            speak("hello, How are You ??");
        }
        if (msg.indexOf("hey mag") != -1) {
            speak("hello, How are You ??");
        }
        if (msg.indexOf("heyy mag") != -1) {
            speak("hello, How are You ??");
        }
        if (msg.indexOf("hey") != -1) {
            speak("hello, How are You ??");
        }

        if (msg.indexOf("tell me a joke") != -1) {
            speak("okayyy, ....wait you are the biggest joke");
        }
        if (msg.indexOf("Kashi aahe") != -1) {
            speak("Mi mast tu kasa aahes!!!!");
        }
        if (msg.indexOf("Kashi hai") != -1) {
            speak("Mi mast tu kasa aahes!!!!");
        }
        if (msg.indexOf("Kashi aahes") != -1) {
            speak("Mi mast tu kasa aahes!!!!");
        }
        if (msg.indexOf("Kashi haii") != -1) {
            speak("Mi mast tu kasa aahes!!!!");
        }
        if (msg.indexOf("emag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("e mag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("a mag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("A mag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("aee mag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("Aee mag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("Aee Mag") != -1) {
            speak("hi vinu,kasa aahes");
        }
        if (msg.indexOf("happy diwali") != -1) {
            speak("happy diwali to you");
        }
        if (msg.indexOf("Happy diwali") != -1) {
            speak("happy diwali to you");
        }
        if (msg.indexOf("Happy Diwali") != -1) {
            speak("happy diwali to you");
        }
        if (msg.indexOf("Shubh diwali") != -1) {
            speak("Shubh diwali to you to");
        }
        if (msg.indexOf("Tula diwalichya Hardik shubhechha") != -1) {
            speak("tula pan diwalichya hardik subhecha pn jassst fatake nako fodus diwe lavvv ani rangoli banavv vinu");
        }
        if (msg.indexOf("Diwali chya Hardik shubhechha") != -1) {
            speak("tula pan diwalichya hardik subhecha pn jassst fatake nako fodus diwe lavvv ani rangoli banavv vinu");
        }
        if (msg.indexOf("mag") != -1) {
            speak("hello Sir ! , How can i help you!");
        }
        if (msg.indexOf("who are you") != -1) {
            speak("i am your voice assistant");
        }
        if (msg.indexOf("why you name is mag") != -1) {
            speak("yup good question , basically mag means my assistant guide, yours assistant guide");
        }
        if (msg.indexOf("who created you") != -1) {
            speak("yeah!! vinayak shinde nikhil bhoir sujal jadhav makrand sawant , they all created me  as i was their mini project...");
        }
        if (msg.indexOf("mag means") != -1) {
            speak("mag means my assistant guide,means your assistant guide, i will assist you in all of your problems");
        }
        if (msg.indexOf("Mag manje") != -1) {
            speak("waghahche panje !!!!! are mag manje  my assistant guide...manje tujhi assistant guide.....samajla ka mitra...");
        }
        if (msg.indexOf("mag manje") != -1) {
            speak("waghahche panje !!!!! are mag manje  my assistant guide...manje tujhi assistant guide.....samajla  ka mitra...");
        }
        if (msg.indexOf("Mag Manje") != -1) {
            speak("waghahche panje !!!!! are mag manje  my assistant guide...manje tujhi assistant guide.....samajla ka mitra...");
        }
        if (msg.indexOf("Mag Manji") != -1) {
            speak("waghahche panje !!!!! are mag manje  my assistant guide...manje tujhi assistant guide.....samajla ka mitra...");
        }
        if (msg.indexOf("full form of mag") != -1) {
            speak("mag means my assistant guide,means your assistant guide, i will assist you in all of your problems");
        }
        if (msg.indexOf("what does mag means") != -1) {
            speak("mag means my assistant guide,means your assistant guide, i will assist you in all of your problems");
        }
        if (msg.indexOf("not fine") != -1) {
            speak("Its good to know that you are fine sir !!  How may i help you");
        }
        if (msg.indexOf("fine") != -1) {
            speak("Its good to know that you are fine sir !!  How may i help you");
        } else if (msg.indexOf("not fine") != -1) {
            speak("Please take Care sir");
        }
        if (msg.indexOf("how") != -1 && msg.indexOf("are you") != -1) {
            speak("i am cool");
        }
        if (msg.indexOf("what") != -1 && msg.indexOf("is my name") != -1) {
            speak("vinayak shinde");
        }
        if (msg.indexOf("play") != -1) {
            if (msg.indexOf("song") != -1) {
                speak("playing from youtube");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/6CBD3NlxaQA"));
                startActivity(intent);
            }
        }
        if (msg.indexOf("when") != -1 && msg.indexOf("is my") != -1 && msg.indexOf("birthday") != -1) {
            speak("ohhhhhh,your birthday is on 30august i remembered");
        }
        if (msg.indexOf("alone") != -1) {
            speak(" why you feel alone when i am present , i am always there with you in any situation");
        }
        if (msg.indexOf("now") != -1 && msg.indexOf("Kai") != -1 && msg.indexOf("Tujha") != -1) {
            speak("mi mag tujhi assistant guide!!!!");
        }
        if (msg.indexOf("nav") != -1 && msg.indexOf("kai") != -1 && msg.indexOf("tujha") != -1) {
            speak("mi mag tujhi assistant guide!!!!");
        }
        if (msg.indexOf("Nav") != -1 && msg.indexOf("Kai") != -1 && msg.indexOf("Tujha") != -1) {
            speak("mi mag tujhi assistant guide!!!!");
        }
        if (msg.indexOf("Nav") != -1 && msg.indexOf("Ky") != -1 && msg.indexOf("Tujha") != -1) {
            speak("mi mag tujhi assistant guide!!!!");
        }
        if (msg.indexOf("now") != -1 && msg.indexOf("Kai") != -1 && msg.indexOf("Tu Jo") != -1) {
            speak("mi mag tujhi assistant guide!!!!");
        }
        if (msg.indexOf("what's") != -1 && msg.indexOf("your") != -1 && msg.indexOf("name") != -1) {
            speak("I am Mag  Your's Assistant Guide");
        }
        if (msg.indexOf("time") != -1 && msg.indexOf("now") != -1) {
            Date date = new Date();
            String Time = DateUtils.formatDateTime(this, date.getTime(), 1);
            speak("The time now is  " + Time);
        }
        if (msg.indexOf("time") != -1 && msg.indexOf("right now") != -1) {
            Date date2 = new Date();
            String Time2 = DateUtils.formatDateTime(this, date2.getTime(), 1);
            speak("The time now is  " + Time2);
        }
        if (msg.indexOf("time") != -1 && msg.indexOf("time") != -1) {
            Date date3 = new Date();
            String Time3 = DateUtils.formatDateTime(this, date3.getTime(), 1);
            speak("The time now is  " + Time3);
        }
        if (msg.indexOf("today") != -1 && msg.indexOf("date") != -1) {
            new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd MM YYYY");
            Calendar cal = Calendar.getInstance();
            String todays_date = df.format(cal.getTime());
            speak(" todays date is   " + todays_date);
        }
        if (msg.indexOf("ajj chi") != -1 && msg.indexOf("tarik") != -1) {
            new Date();
            SimpleDateFormat df = new SimpleDateFormat("dd MM YYYY");
            Calendar cal = Calendar.getInstance();
            String todays_date = df.format(cal.getTime());
            speak(" todays date is   " + todays_date);
        }
        if (msg.indexOf("today's weather") != -1) {
            speak("lets see todays weather from google");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=todays+weather"));
            startActivity(intent);

        }
        if (msg.indexOf("turn on bluetooth") != -1) {
            if (!bluetoothAdapter.isEnabled()) {
                speak("Turning On Bluetooth...");
                // intent to on bluetooth
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, REQUEST_ENABLE_BT);
            } else {
                speak("Bluetooth is already on");
            }
            if (msg.indexOf("turn of bluetooth") != -1) {
                if (bluetoothAdapter.isEnabled()) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    bluetoothAdapter.disable();
                    speak("Turning Bluetooth Off");
                } else {
                    speak("Bluetooth is already off");
                }

            }


        }
        if (msg.indexOf("call") != -1) {
            //final String[] listname = {""};
            //final String name = fetchname(msg);
            //Log.d( "Name",name);

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, (Integer) READCONTACTS);
            } else {
                String keeper = null;
                String name = keeper.split("call")[1].trim();
                Log.d("chk", name);
                try {
                    Cursor cursor = getContentResolver().query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE},
                            "DISPLAY_NAME = '" + name + "'",
                            null,
                            null);
                    cursor.moveToFirst();
                    String number = cursor.getString(0);
                    // number must not have any spaces
                    if (number.trim().length() > 0) {
                        // runtime message
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUESTCALL);
                        } else {
                            // passing intent
                            String dial = "tel:" + number;
                            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                        }
                    } else {
                        // invalid phone
                        Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    speak("Something went wrong");
                }
            }


        }


            if (msg.indexOf("where is") != -1) {
                if (msg.indexOf(msg2) != -1) {
                    speak("lets find" + msg2);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/@37.0625,-95.677068,3z" + msg2));
                    startActivity(intent);
                }

                if (msg.indexOf("today's") != -1) {
                    if (msg.indexOf("weather") != -1) {
                        speak("lets se todays weather from google");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=todays+weather"));
                        startActivity(intent);
                    }
                }
                if (msg.indexOf("TODAYS") != -1) {
                    if (msg.indexOf("WEATHER") != -1) {
                        speak("lets se todays weather from google");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=todays+weather"));
                        startActivity(intent);
                    }
                }
            }
            if (msg.indexOf("play") != -1) {
                if (msg.indexOf("song") != -1) {
                    speak("playing from youtube");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/X8t8axbZnH8"));
                    startActivity(intent);
                }
            }
            if (msg.indexOf("play") != -1) {
                if (msg.indexOf(msg) != -1) {
                    speak("playing"+msg+"from youtube");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/results?search_query=" + msg));
                    startActivity(intent);
                }
            }
            if (msg.indexOf("where is") != -1) {
                if (msg.indexOf(msg) != -1) {
                    speak("showing" + msg2);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=" + msg2));
                    startActivity(intent);
                }
            }
            if (msg.indexOf("what is") != -1) {
                if (msg.indexOf(msg2) != -1) {
                    speak("showing" + msg2);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=" + msg2));
                    startActivity(intent);
                }
            }
            if (msg.indexOf("why") != -1) {
                if (msg.indexOf(msg2) != -1) {
                    speak("showing" + msg2);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=" + msg2));
                    startActivity(intent);
                }
            }
            if (msg.indexOf("how to") != -1) {
                if (msg.indexOf(msg) != -1) {
                    speak("showing" + msg2);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=." + msg2));
                    startActivity(intent);
                }
            }

            if (msg.indexOf("open") != -1) {
                if (msg.indexOf("google") != -1) {
                    speak("opening google");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/search?q=."));
                    startActivity(intent);
                }
                if (msg.indexOf("browser") != -1) {
                    speak("opening browser");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/"));
                    startActivity(intent);
                }
                if (msg.indexOf("chrome") != -1) {
                    speak("opening chrome");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.chrome.com/"));
                    startActivity(intent);
                }
                if (msg.indexOf("youtube") != -1) {
                    speak("opening youtube");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/"));
                    startActivity(intent);
                }
                if (msg.indexOf("facebook") != -1) {
                    speak("opening facebook");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/"));
                    startActivity(intent);
                }
                if (msg.indexOf("facebook") != -1) {
                    speak("opening facebook");
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.facebook.com/"));
                    startActivity(intent);
                }
                if (msg.indexOf("Instagram") != -1) {
                    speak("opening instagram");
                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse("com.instagram.android"));
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
                    startActivity(intent);
                }
                if (msg.indexOf("instagram") != -1) {
                    speak("opening instagram");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.instagram.com/"));
                    startActivity(intent);
                }

                if (msg.indexOf("WhatsApp") != -1) {
                    speak("opening whatsapp");
                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse("com.whatsapp"));
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                    startActivity(intent);

                }
                if (msg.indexOf("whatsapp") != -1) {
                    speak("opening whatsapp");
                    Context ctx = this;

                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                    startActivity(intent);
                }
                if (msg.indexOf("Snapchat") != -1) {
                    speak("opening snapchat");

                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse("com.snapchat.android"));
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                    startActivity(intent);
                }
                if (msg.indexOf("snapchat") != -1) {
                    speak("opening snapchat");
                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse("com.snapchat.android"));
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                    startActivity(intent);
                }
                if (msg.indexOf("SNAPCHAT") != -1) {
                    speak("opening snapchat");
                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse("com.snapchat.android"));
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.snapchat.android");
                    startActivity(intent);
                }

                if (msg.indexOf("facebook") != -1) {
                    speak("opening facebook");
                    Context ctx = this;
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.facebook.android");
                    startActivity(intent);
                }
                if (msg.indexOf("youtube") != -1) {
                    speak("opening youtube");
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.youtube.android");
                    startActivity(intent);
                }
                if (msg.indexOf("Twitter") != -1) {
                    speak("opening twitter");
                    Context ctx = this;
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.twitter.android");
                    startActivity(intent);
                }
            }

            if (msg.indexOf("play") != -1) {

                if (msg.indexOf("elevated") != -1) {
                    speak("playing"+msg+"from youtube");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/I1nX5EuvwzE"));
                    startActivity(intent);
                }
                if (msg.indexOf("HANUMAN CHALISA") != -1) {
                    speak("playing"+msg+"from youtube");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/ANk4fmRNyuE"));
                    startActivity(intent);
                }
                if (msg.indexOf("hanuman chalisa") != -1) {
                    speak("playing"+msg+"from youtube");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/ANk4fmRNyuE"));
                    startActivity(intent);
                }
                if (msg.indexOf("baller") != -1) {
                    speak("playing"+msg+"from youtube");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/xR3V5Ow2dTI"));
                    startActivity(intent);
                }
                if (msg.indexOf("295") != -1) {
                    speak("playing"+msg+"from youtube");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/295"));
                    startActivity(intent);
                }
                if (msg.indexOf("brown munde") != -1) {
                    speak("playing"+msg+"from youtube");
                    Context ctx = this;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://youtu.be/VNs_cCtdbPc"));
                    startActivity(intent);
                }
                if (msg.indexOf(msg) != -1) {
                    Context ctx = this;
                    Intent i = new Intent("android.intent.action.VIEW", Uri.parse("com.youtube.android" + msg));
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("com.youtube.android" + msg));
                    startActivity(intent);
                }

            }

        if(msg.indexOf("turn on flash")!=-1){
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    CameraManager cameraManager = null;
                    String cameraID = cameraManager.getCameraIdList()[0];
                    cameraManager.setTorchMode(cameraID, true);
                    speak("Flash turned on");
                }
            } catch (Exception e) {
                e.printStackTrace();
                speak("Error Occured");
            }

        }
        if(msg.indexOf("turn of flash")!=-1){
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    CameraManager cameraManager = null;
                    String cameraID = null;
                    cameraManager.setTorchMode(cameraID, false);
                    speak("Flash turned off");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



if(msg.indexOf("send sms to")!=-1){
    if(msg.indexOf(msg2)!=-1){
        Log.d("keeper", "Done0");
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SENDSMS
            );
            Log.d("keeper", "Done1");
        } else {
            Log.d("keeper", "Done2");
            String keeper = null;
            String keeperReplaced = keeper.replace(" ", "");
            String[] number = keeperReplaced.split("o");
            String message = keeper.split("that")[1];
            Log.d("chk", number[1] + message);
            SmsManager mySmsManager = SmsManager.getDefault();
            mySmsManager.sendTextMessage(
                    number[1].trim(),
                    null,
                    message.trim(),
                    null,
                    null
            );
            speak("Message sent that " + message);
        }


    }
}
        }


    private void readSMS() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_SMS
        ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.READ_SMS},
                    READSMS
            );
        } else {
            Cursor cursor = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
            cursor.moveToFirst();
            speak("Your last message was " + cursor.getString(12));
        }
    }


    public void startRecording(View view) {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.MAX_RESULTS", 1);
        this.recognizer.startListening(intent);
    }
}
