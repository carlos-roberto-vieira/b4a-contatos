package br.tssistemas.contatos;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "br.tssistemas.contatos", "br.tssistemas.contatos.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "br.tssistemas.contatos", "br.tssistemas.contatos.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "br.tssistemas.contatos.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static br.tssistemas.contatos.contactsutils _cu = null;
public static anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static long _contactid = 0L;
public anywheresoftware.b4a.objects.B4XViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _edittext1 = null;
public b4a.example3.customlistview _clv1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcontato = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtfone = null;
public anywheresoftware.b4a.objects.PanelWrapper _pa = null;
public com.tomlost.MSSQL.MSSQL _cn = null;
public anywheresoftware.b4a.objects.collections.List _alist = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btimportar = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btexcluirimportados = null;
public anywheresoftware.b4a.objects.Timer _timer = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
public anywheresoftware.b4a.objects.PanelWrapper _pac = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static void  _activity_create(boolean _firsttime) throws Exception{
ResumableSub_Activity_Create rsub = new ResumableSub_Activity_Create(null,_firsttime);
rsub.resume(processBA, null);
}
public static class ResumableSub_Activity_Create extends BA.ResumableSub {
public ResumableSub_Activity_Create(br.tssistemas.contatos.main parent,boolean _firsttime) {
this.parent = parent;
this._firsttime = _firsttime;
}
br.tssistemas.contatos.main parent;
boolean _firsttime;
String _permission = "";
boolean _result = false;
br.tssistemas.contatos.contactsutils._cucontact _c = null;
anywheresoftware.b4a.BA.IterableList group15;
int index15;
int groupLen15;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 57;BA.debugLine="If FirstTime Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_firsttime) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 58;BA.debugLine="cu.Initialize";
parent._cu._initialize /*String*/ (processBA);
 //BA.debugLineNum = 59;BA.debugLine="cr.Initialize(\"cr\")";
parent.mostCurrent._cr.Initialize("cr");
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 62;BA.debugLine="Activity.LoadLayout(\"1\")";
parent.mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 //BA.debugLineNum = 63;BA.debugLine="pac.Visible=False";
parent.mostCurrent._pac.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 66;BA.debugLine="timer.Enabled = False";
parent.mostCurrent._timer.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 67;BA.debugLine="timer.Interval = 6000";
parent.mostCurrent._timer.setInterval((long) (6000));
 //BA.debugLineNum = 69;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_READ_CONTACTS)";
parent._rp.CheckAndRequest(processBA,parent._rp.PERMISSION_READ_CONTACTS);
 //BA.debugLineNum = 70;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 21;
return;
case 21:
//C
this.state = 5;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 71;BA.debugLine="If Result Then";
if (true) break;

case 5:
//if
this.state = 20;
if (_result) { 
this.state = 7;
}else {
this.state = 19;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 73;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_CONTACTS)";
parent._rp.CheckAndRequest(processBA,parent._rp.PERMISSION_WRITE_CONTACTS);
 //BA.debugLineNum = 74;BA.debugLine="Wait For Activity_PermissionResult (Permission A";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 22;
return;
case 22:
//C
this.state = 8;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 75;BA.debugLine="If Result Then";
if (true) break;

case 8:
//if
this.state = 17;
if (_result) { 
this.state = 10;
}else {
this.state = 16;
}if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 76;BA.debugLine="For Each c As cuContact In cu.FindAllContacts(T";
if (true) break;

case 11:
//for
this.state = 14;
group15 = parent._cu._findallcontacts /*anywheresoftware.b4a.objects.collections.List*/ (anywheresoftware.b4a.keywords.Common.True);
index15 = 0;
groupLen15 = group15.getSize();
this.state = 23;
if (true) break;

case 23:
//C
this.state = 14;
if (index15 < groupLen15) {
this.state = 13;
_c = (br.tssistemas.contatos.contactsutils._cucontact)(group15.Get(index15));}
if (true) break;

case 24:
//C
this.state = 23;
index15++;
if (true) break;

case 13:
//C
this.state = 24;
 //BA.debugLineNum = 77;BA.debugLine="CLV1.AddTextItem(c.DisplayName, c)";
parent.mostCurrent._clv1._addtextitem((Object)(_c.DisplayName /*String*/ ),(Object)(_c));
 if (true) break;
if (true) break;

case 14:
//C
this.state = 17;
;
 if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"No permission\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 17:
//C
this.state = 20;
;
 if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 84;BA.debugLine="ToastMessageShow(\"No permission\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 20:
//C
this.state = -1;
;
 //BA.debugLineNum = 87;BA.debugLine="pa.Initialize( \"\" )";
parent.mostCurrent._pa.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 88;BA.debugLine="lbl.Initialize( \"\" )";
parent.mostCurrent._lbl.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 89;BA.debugLine="lbl.Text = \"Aqui\"";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence("Aqui"));
 //BA.debugLineNum = 90;BA.debugLine="lbl.TextSize=16";
parent.mostCurrent._lbl.setTextSize((float) (16));
 //BA.debugLineNum = 91;BA.debugLine="lbl.TextColor = Colors.White";
parent.mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 92;BA.debugLine="lbl.Gravity=Gravity.CENTER_HORIZONTAL";
parent.mostCurrent._lbl.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL);
 //BA.debugLineNum = 94;BA.debugLine="pa.Color = Colors.RGB( 106, 142, 174 )";
parent.mostCurrent._pa.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (106),(int) (142),(int) (174)));
 //BA.debugLineNum = 96;BA.debugLine="pa.AddView( lbl, 0%x, 12%y, 90%x, 12%y )";
parent.mostCurrent._pa.AddView((android.view.View)(parent.mostCurrent._lbl.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (12),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (12),mostCurrent.activityBA));
 //BA.debugLineNum = 97;BA.debugLine="Activity.AddView( pa, 5%x, 20%y, 90%x, 30%y )";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._pa.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (5),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (20),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (90),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 99;BA.debugLine="pa.Visible=False";
parent.mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _activity_permissionresult(String _permission,boolean _result) throws Exception{
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public static String  _btadicionar_click() throws Exception{
 //BA.debugLineNum = 230;BA.debugLine="Sub btAdicionar_Click";
 //BA.debugLineNum = 231;BA.debugLine="pac.Visible=True";
mostCurrent._pac.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public static String  _btcancelar_click() throws Exception{
 //BA.debugLineNum = 226;BA.debugLine="Sub btCancelar_Click";
 //BA.debugLineNum = 227;BA.debugLine="pac.Visible=False";
mostCurrent._pac.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public static String  _btexcluir_click() throws Exception{
int _n = 0;
br.tssistemas.contatos.contactsutils._cucontact _c = null;
 //BA.debugLineNum = 159;BA.debugLine="Sub btExcluir_Click";
 //BA.debugLineNum = 161;BA.debugLine="If contactId  > 0 Then";
if (_contactid>0) { 
 //BA.debugLineNum = 163;BA.debugLine="Dim n As Int";
_n = 0;
 //BA.debugLineNum = 164;BA.debugLine="n = Msgbox2(  \"Deseja Excluir deste Contato  ?\",";
_n = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Deseja Excluir deste Contato  ?"),BA.ObjectToCharSequence("Excluir ?"),"Sim","","Não",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 165;BA.debugLine="If n = DialogResponse.POSITIVE Then";
if (_n==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 167;BA.debugLine="n = Msgbox2( \"Ultima Chance, Excluir ?\", \"Certe";
_n = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Ultima Chance, Excluir ?"),BA.ObjectToCharSequence("Certeza ?"),"Sim","","Não",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 169;BA.debugLine="If n = DialogResponse.POSITIVE Then";
if (_n==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 170;BA.debugLine="cu.DeleteContact( contactId )";
_cu._deletecontact /*String*/ (_contactid);
 //BA.debugLineNum = 172;BA.debugLine="EditText1.Text = \"\"";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 174;BA.debugLine="CLV1.Clear";
mostCurrent._clv1._clear();
 //BA.debugLineNum = 175;BA.debugLine="For Each c As cuContact In cu.FindAllContacts(";
{
final anywheresoftware.b4a.BA.IterableList group10 = _cu._findallcontacts /*anywheresoftware.b4a.objects.collections.List*/ (anywheresoftware.b4a.keywords.Common.True);
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_c = (br.tssistemas.contatos.contactsutils._cucontact)(group10.Get(index10));
 //BA.debugLineNum = 176;BA.debugLine="CLV1.AddTextItem(c.DisplayName, c)";
mostCurrent._clv1._addtextitem((Object)(_c.DisplayName /*String*/ ),(Object)(_c));
 }
};
 };
 };
 };
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public static void  _btexcluirimportados_click() throws Exception{
ResumableSub_btExcluirImportados_Click rsub = new ResumableSub_btExcluirImportados_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btExcluirImportados_Click extends BA.ResumableSub {
public ResumableSub_btExcluirImportados_Click(br.tssistemas.contatos.main parent) {
this.parent = parent;
}
br.tssistemas.contatos.main parent;
boolean _result = false;
br.tssistemas.contatos.contactsutils._cucontact _c = null;
anywheresoftware.b4a.BA.IterableList group5;
int index5;
int groupLen5;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 237;BA.debugLine="Wait For( ExcluirContatosImportados) Complete (Re";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, _excluircontatosimportados());
this.state = 5;
return;
case 5:
//C
this.state = 1;
_result = (Boolean) result[0];
;
 //BA.debugLineNum = 240;BA.debugLine="lbl.Text =\"Atualizando Lista ...\"";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence("Atualizando Lista ..."));
 //BA.debugLineNum = 241;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 244;BA.debugLine="CLV1.Clear";
parent.mostCurrent._clv1._clear();
 //BA.debugLineNum = 246;BA.debugLine="For Each c As cuContact In cu.FindAllContacts(Tru";
if (true) break;

case 1:
//for
this.state = 4;
group5 = parent._cu._findallcontacts /*anywheresoftware.b4a.objects.collections.List*/ (anywheresoftware.b4a.keywords.Common.True);
index5 = 0;
groupLen5 = group5.getSize();
this.state = 6;
if (true) break;

case 6:
//C
this.state = 4;
if (index5 < groupLen5) {
this.state = 3;
_c = (br.tssistemas.contatos.contactsutils._cucontact)(group5.Get(index5));}
if (true) break;

case 7:
//C
this.state = 6;
index5++;
if (true) break;

case 3:
//C
this.state = 7;
 //BA.debugLineNum = 247;BA.debugLine="CLV1.AddTextItem(c.DisplayName, c)";
parent.mostCurrent._clv1._addtextitem((Object)(_c.DisplayName /*String*/ ),(Object)(_c));
 if (true) break;
if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 250;BA.debugLine="CLV1.PressedColor = Colors.Green";
parent.mostCurrent._clv1._pressedcolor = anywheresoftware.b4a.keywords.Common.Colors.Green;
 //BA.debugLineNum = 252;BA.debugLine="lbl.Text = \"Pronto\"";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence("Pronto"));
 //BA.debugLineNum = 253;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 255;BA.debugLine="lbl.Visible=False";
parent.mostCurrent._lbl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 256;BA.debugLine="pa.Visible=False";
parent.mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 260;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _complete(boolean _result) throws Exception{
}
public static String  _btimportar_click() throws Exception{
br.tssistemas.contatos.contactsutils._cucontact _c = null;
 //BA.debugLineNum = 340;BA.debugLine="Sub btImportar_Click";
 //BA.debugLineNum = 342;BA.debugLine="IMPORTAR_CLIENTES( True )";
_importar_clientes(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 345;BA.debugLine="lbl.Text =\"Atualizando Lista ...\"";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Atualizando Lista ..."));
 //BA.debugLineNum = 346;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 349;BA.debugLine="CLV1.Clear";
mostCurrent._clv1._clear();
 //BA.debugLineNum = 351;BA.debugLine="For Each c As cuContact In cu.FindAllContacts(Tru";
{
final anywheresoftware.b4a.BA.IterableList group5 = _cu._findallcontacts /*anywheresoftware.b4a.objects.collections.List*/ (anywheresoftware.b4a.keywords.Common.True);
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_c = (br.tssistemas.contatos.contactsutils._cucontact)(group5.Get(index5));
 //BA.debugLineNum = 352;BA.debugLine="CLV1.AddTextItem(c.DisplayName, c)";
mostCurrent._clv1._addtextitem((Object)(_c.DisplayName /*String*/ ),(Object)(_c));
 }
};
 //BA.debugLineNum = 355;BA.debugLine="CLV1.PressedColor = Colors.Green";
mostCurrent._clv1._pressedcolor = anywheresoftware.b4a.keywords.Common.Colors.Green;
 //BA.debugLineNum = 357;BA.debugLine="lbl.Text = \"Pronto\"";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Pronto"));
 //BA.debugLineNum = 358;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 360;BA.debugLine="lbl.Visible=False";
mostCurrent._lbl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 361;BA.debugLine="pa.Visible=False";
mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public static String  _btsalvar_click() throws Exception{
br.tssistemas.contatos.contactsutils._cucontact _c = null;
 //BA.debugLineNum = 201;BA.debugLine="Sub btSalvar_Click";
 //BA.debugLineNum = 203;BA.debugLine="pac.Visible=False";
mostCurrent._pac.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 205;BA.debugLine="If txtContato.Text.Trim <> \"\" And _  	   txtFone.";
if ((mostCurrent._txtcontato.getText().trim()).equals("") == false && (mostCurrent._txtfone.getText().trim()).equals("") == false) { 
 //BA.debugLineNum = 208;BA.debugLine="cu.InsertContact(  txtContato.Text, txtFone.Text";
_cu._insertcontact /*br.tssistemas.contatos.contactsutils._cucontact*/ (mostCurrent._txtcontato.getText(),mostCurrent._txtfone.getText());
 //BA.debugLineNum = 210;BA.debugLine="CLV1.Clear";
mostCurrent._clv1._clear();
 //BA.debugLineNum = 212;BA.debugLine="For Each c As cuContact In cu.FindAllContacts(Tr";
{
final anywheresoftware.b4a.BA.IterableList group5 = _cu._findallcontacts /*anywheresoftware.b4a.objects.collections.List*/ (anywheresoftware.b4a.keywords.Common.True);
final int groupLen5 = group5.getSize()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_c = (br.tssistemas.contatos.contactsutils._cucontact)(group5.Get(index5));
 //BA.debugLineNum = 213;BA.debugLine="CLV1.AddTextItem(c.DisplayName, c)";
mostCurrent._clv1._addtextitem((Object)(_c.DisplayName /*String*/ ),(Object)(_c));
 }
};
 //BA.debugLineNum = 216;BA.debugLine="CLV1.PressedColor = Colors.Green";
mostCurrent._clv1._pressedcolor = anywheresoftware.b4a.keywords.Common.Colors.Green;
 //BA.debugLineNum = 219;BA.debugLine="txtContato.Text = \"\"";
mostCurrent._txtcontato.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 220;BA.debugLine="txtFone.Text = \"\"";
mostCurrent._txtfone.setText(BA.ObjectToCharSequence(""));
 };
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public static String  _clv1_itemclick(int _index,Object _value) throws Exception{
br.tssistemas.contatos.contactsutils._cucontact _c = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
br.tssistemas.contatos.contactsutils._cuphone _phone = null;
br.tssistemas.contatos.contactsutils._cuemail _email = null;
 //BA.debugLineNum = 121;BA.debugLine="Sub CLV1_ItemClick (Index As Int, Value As Object)";
 //BA.debugLineNum = 122;BA.debugLine="Dim c As cuContact = Value";
_c = (br.tssistemas.contatos.contactsutils._cucontact)(_value);
 //BA.debugLineNum = 124;BA.debugLine="contactId = c.Id";
_contactid = _c.Id /*long*/ ;
 //BA.debugLineNum = 126;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(c.Id)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = _cu._getphoto /*anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper*/ (_c.Id /*long*/ );
 //BA.debugLineNum = 127;BA.debugLine="If bmp.IsInitialized Then ImageView1.SetBitmap(bm";
if (_bmp.IsInitialized()) { 
mostCurrent._imageview1.SetBitmap((android.graphics.Bitmap)(_bmp.getObject()));}
else {
mostCurrent._imageview1.SetBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));};
 //BA.debugLineNum = 128;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 129;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 130;BA.debugLine="sb.Append(c.DisplayName).Append(CRLF).Append(\"Not";
_sb.Append(_c.DisplayName /*String*/ ).Append(anywheresoftware.b4a.keywords.Common.CRLF).Append("Note: ").Append(_cu._getnote /*String*/ (_c.Id /*long*/ )).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 132;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(c.Id)";
{
final anywheresoftware.b4a.BA.IterableList group8 = _cu._getphones /*anywheresoftware.b4a.objects.collections.List*/ (_c.Id /*long*/ );
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_phone = (br.tssistemas.contatos.contactsutils._cuphone)(group8.Get(index8));
 //BA.debugLineNum = 133;BA.debugLine="sb.Append(phone.Number & \", \" & phone.PhoneType)";
_sb.Append(_phone.Number /*String*/ +", "+_phone.PhoneType /*String*/ ).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 }
};
 //BA.debugLineNum = 135;BA.debugLine="For Each email As cuEmail In cu.GetEmails(c.Id)";
{
final anywheresoftware.b4a.BA.IterableList group11 = _cu._getemails /*anywheresoftware.b4a.objects.collections.List*/ (_c.Id /*long*/ );
final int groupLen11 = group11.getSize()
;int index11 = 0;
;
for (; index11 < groupLen11;index11++){
_email = (br.tssistemas.contatos.contactsutils._cuemail)(group11.Get(index11));
 //BA.debugLineNum = 136;BA.debugLine="sb.Append(email.email).Append(\", \").Append(email";
_sb.Append(_email.Email /*String*/ ).Append(", ").Append(_email.EmailType /*String*/ ).Append(anywheresoftware.b4a.keywords.Common.CRLF);
 }
};
 //BA.debugLineNum = 138;BA.debugLine="EditText1.Text = sb.ToString";
mostCurrent._edittext1.setText(BA.ObjectToCharSequence(_sb.ToString()));
 //BA.debugLineNum = 140;BA.debugLine="cu.SetNote( contactId, \"Olá sou uma notação\" )";
_cu._setnote /*String*/ (_contactid,"Olá sou uma notação");
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _clv1_itemlongclick(int _index,Object _value) throws Exception{
br.tssistemas.contatos.contactsutils._cucontact _c = null;
 //BA.debugLineNum = 113;BA.debugLine="Sub CLV1_ItemLongClick (Index As Int, Value As Obj";
 //BA.debugLineNum = 114;BA.debugLine="Dim c As cuContact = Value";
_c = (br.tssistemas.contatos.contactsutils._cucontact)(_value);
 //BA.debugLineNum = 115;BA.debugLine="cu.SetStarred(c.Id, Not(cu.GetStarred(c.Id)))";
_cu._setstarred /*String*/ (_c.Id /*long*/ ,anywheresoftware.b4a.keywords.Common.Not(_cu._getstarred /*boolean*/ (_c.Id /*long*/ )));
 //BA.debugLineNum = 117;BA.debugLine="CLV1_ItemClick(Index, Value)";
_clv1_itemclick(_index,_value);
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static String  _cr_querycompleted(boolean _success,anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr) throws Exception{
boolean _parimportargeral = false;
int _n = 0;
int _i = 0;
String _display_name = "";
 //BA.debugLineNum = 275;BA.debugLine="Sub CR_QueryCompleted (Success As Boolean, Crsr As";
 //BA.debugLineNum = 277;BA.debugLine="If Success = False Then";
if (_success==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 278;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("4851971",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 }else {
 //BA.debugLineNum = 282;BA.debugLine="Dim parImportarGeral As Boolean = False";
_parimportargeral = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 284;BA.debugLine="Dim n As Int";
_n = 0;
 //BA.debugLineNum = 285;BA.debugLine="n = Msgbox2(  \"Excluir Todos os Clientes ?\", \"Ex";
_n = anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("Excluir Todos os Clientes ?"),BA.ObjectToCharSequence("Excluir ?"),"Sim","","Não",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA);
 //BA.debugLineNum = 288;BA.debugLine="pa.Visible=True";
mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 289;BA.debugLine="lbl.Visible=True";
mostCurrent._lbl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 291;BA.debugLine="If n = DialogResponse.POSITIVE Then";
if (_n==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 293;BA.debugLine="parImportarGeral = True";
_parimportargeral = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 295;BA.debugLine="lbl.Text = \"Excluíndo Contatos *-\"";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Excluíndo Contatos *-"));
 //BA.debugLineNum = 296;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 298;BA.debugLine="For i = 0 To Crsr.RowCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 300;BA.debugLine="Crsr.Position = i";
_crsr.setPosition(_i);
 //BA.debugLineNum = 301;BA.debugLine="Dim display_name As String  =   Crsr.GetString";
_display_name = _crsr.GetString("display_name");
 //BA.debugLineNum = 303;BA.debugLine="Try";
try { //BA.debugLineNum = 304;BA.debugLine="If display_name.SubString2( 0, 2 ) = \"*-\" The";
if ((_display_name.substring((int) (0),(int) (2))).equals("*-")) { 
 //BA.debugLineNum = 305;BA.debugLine="cu.DeleteContact( Crsr.GetLong(\"_id\") )";
_cu._deletecontact /*String*/ (_crsr.GetLong("_id"));
 };
 //BA.debugLineNum = 308;BA.debugLine="If display_name.SubString2( 0, 2 ) = \"A-\" The";
if ((_display_name.substring((int) (0),(int) (2))).equals("A-")) { 
 //BA.debugLineNum = 309;BA.debugLine="cu.DeleteContact( Crsr.GetLong(\"_id\") )";
_cu._deletecontact /*String*/ (_crsr.GetLong("_id"));
 };
 //BA.debugLineNum = 313;BA.debugLine="If display_name.SubString2( 0, 2 ) = \"A \" The";
if ((_display_name.substring((int) (0),(int) (2))).equals("A ")) { 
 //BA.debugLineNum = 314;BA.debugLine="cu.DeleteContact( Crsr.GetLong(\"_id\") )";
_cu._deletecontact /*String*/ (_crsr.GetLong("_id"));
 };
 } 
       catch (Exception e27) {
			processBA.setLastException(e27); //BA.debugLineNum = 319;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("4852012",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 }
};
 //BA.debugLineNum = 323;BA.debugLine="Crsr.Close";
_crsr.Close();
 };
 //BA.debugLineNum = 328;BA.debugLine="lbl.Visible=False";
mostCurrent._lbl.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 329;BA.debugLine="pa.Visible=False";
mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _excluircontatosimportados() throws Exception{
ResumableSub_ExcluirContatosImportados rsub = new ResumableSub_ExcluirContatosImportados(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_ExcluirContatosImportados extends BA.ResumableSub {
public ResumableSub_ExcluirContatosImportados(br.tssistemas.contatos.main parent) {
this.parent = parent;
}
br.tssistemas.contatos.main parent;
String[] _peopleprojection = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = -1;
 //BA.debugLineNum = 264;BA.debugLine="Private PeopleProjection() As String = Array As S";
_peopleprojection = new String[]{"times_contacted","last_time_contacted","display_name","has_phone_number","starred","_id","photo_id"};
 //BA.debugLineNum = 268;BA.debugLine="Dim u As Uri";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 269;BA.debugLine="u.Parse(\"content://com.android.contacts/contacts\"";
_u.Parse("content://com.android.contacts/contacts");
 //BA.debugLineNum = 270;BA.debugLine="cr.QueryAsync(u,  PeopleProjection, \"\", Null, \"\"";
parent.mostCurrent._cr.QueryAsync(processBA,_u,_peopleprojection,"",(String[])(anywheresoftware.b4a.keywords.Common.Null),"");
 //BA.debugLineNum = 271;BA.debugLine="Return (True )";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)((anywheresoftware.b4a.keywords.Common.True)));return;};
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 30;BA.debugLine="Dim contactId As Long";
_contactid = 0L;
 //BA.debugLineNum = 31;BA.debugLine="Private ImageView1 As B4XView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 32;BA.debugLine="Private EditText1 As B4XView";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private CLV1 As CustomListView";
mostCurrent._clv1 = new b4a.example3.customlistview();
 //BA.debugLineNum = 34;BA.debugLine="Private txtContato As EditText";
mostCurrent._txtcontato = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private txtFone As EditText";
mostCurrent._txtfone = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private pa As Panel";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Dim cn As MSSQL";
mostCurrent._cn = new com.tomlost.MSSQL.MSSQL();
 //BA.debugLineNum = 39;BA.debugLine="Dim aList As List";
mostCurrent._alist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 41;BA.debugLine="Private cr As ContentResolver";
mostCurrent._cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private btImportar As Button";
mostCurrent._btimportar = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private btExcluirImportados As Button";
mostCurrent._btexcluirimportados = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim timer As Timer";
mostCurrent._timer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 48;BA.debugLine="Dim pa As Panel";
mostCurrent._pa = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="Dim lbl As Label";
mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Private pac As Panel";
mostCurrent._pac = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _importar_clientes(boolean _parimportargeral) throws Exception{
String[] _acampos = null;
String _adados = "";
String[] _bcampos = null;
long _nreg = 0L;
String _vsql = "";
int _i = 0;
int _n = 0;
 //BA.debugLineNum = 368;BA.debugLine="Sub IMPORTAR_CLIENTES( parImportarGeral As Boolean";
 //BA.debugLineNum = 370;BA.debugLine="pa.Visible=True";
mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 371;BA.debugLine="lbl.Visible=True";
mostCurrent._lbl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 373;BA.debugLine="lbl.Text = \"Aguarde ...\" & CRLF & \"Conectando ao";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Aguarde ..."+anywheresoftware.b4a.keywords.Common.CRLF+"Conectando ao DB"));
 //BA.debugLineNum = 374;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 378;BA.debugLine="cn.setDatabase( \"192.168.1.109\", \"softcom\", \"sa\",";
mostCurrent._cn.setDatabase("192.168.1.109","softcom","sa","254685ro");
 //BA.debugLineNum = 380;BA.debugLine="aList = cn.TableList";
mostCurrent._alist.setObject((java.util.List)(mostCurrent._cn.TableList()));
 //BA.debugLineNum = 383;BA.debugLine="If aList.IsInitialized=False Then";
if (mostCurrent._alist.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 384;BA.debugLine="btImportar.Text = \"Importar\"";
mostCurrent._btimportar.setText(BA.ObjectToCharSequence("Importar"));
 //BA.debugLineNum = 385;BA.debugLine="Msgbox( \"Problemas na conexão !\", \"Ops !\" )";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Problemas na conexão !"),BA.ObjectToCharSequence("Ops !"),mostCurrent.activityBA);
 //BA.debugLineNum = 386;BA.debugLine="lbl.Text = LastException.Message";
mostCurrent._lbl.setText(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()));
 //BA.debugLineNum = 387;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 390;BA.debugLine="lbl.Text = \"Importando Clientes ...\"";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Importando Clientes ..."));
 //BA.debugLineNum = 391;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 //BA.debugLineNum = 393;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd/MM/yyyy");
 //BA.debugLineNum = 395;BA.debugLine="Dim aCampos() As String";
_acampos = new String[(int) (0)];
java.util.Arrays.fill(_acampos,"");
 //BA.debugLineNum = 396;BA.debugLine="Dim aDados As String";
_adados = "";
 //BA.debugLineNum = 397;BA.debugLine="Dim bCampos() As String";
_bcampos = new String[(int) (0)];
java.util.Arrays.fill(_bcampos,"");
 //BA.debugLineNum = 399;BA.debugLine="Dim nReg As Long";
_nreg = 0L;
 //BA.debugLineNum = 400;BA.debugLine="Dim vsql As String";
_vsql = "";
 //BA.debugLineNum = 402;BA.debugLine="Try";
try { //BA.debugLineNum = 404;BA.debugLine="pa.Visible=True";
mostCurrent._pa.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 405;BA.debugLine="lbl.Visible=True";
mostCurrent._lbl.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 407;BA.debugLine="aList = cn.Query( \"exec bot.usp_clientes\")";
mostCurrent._alist.setObject((java.util.List)(mostCurrent._cn.Query("exec bot.usp_clientes")));
 //BA.debugLineNum = 409;BA.debugLine="nReg = ( aList.Size - 1 )";
_nreg = (long) ((mostCurrent._alist.getSize()-1));
 //BA.debugLineNum = 410;BA.debugLine="If ( nReg  > 0 ) Then";
if ((_nreg>0)) { 
 //BA.debugLineNum = 413;BA.debugLine="bCampos = Array As String( \"\", \"\", \"\", \"\", \"\",";
_bcampos = new String[]{"","","","","","","","","","","",""};
 //BA.debugLineNum = 415;BA.debugLine="For  i =  1 To nReg";
{
final int step28 = 1;
final int limit28 = (int) (_nreg);
_i = (int) (1) ;
for (;_i <= limit28 ;_i = _i + step28 ) {
 //BA.debugLineNum = 417;BA.debugLine="aDados = aList.Get(i)";
_adados = BA.ObjectToString(mostCurrent._alist.Get(_i));
 //BA.debugLineNum = 418;BA.debugLine="aCampos = Regex.Split( \",\",  aDados.Replace(\"[";
_acampos = anywheresoftware.b4a.keywords.Common.Regex.Split(",",_adados.replace("[","").replace("]",""));
 //BA.debugLineNum = 421;BA.debugLine="bCampos(0) = \"\"";
_bcampos[(int) (0)] = "";
 //BA.debugLineNum = 422;BA.debugLine="bCampos(1) = \"\"";
_bcampos[(int) (1)] = "";
 //BA.debugLineNum = 423;BA.debugLine="bCampos(2) = \"\"";
_bcampos[(int) (2)] = "";
 //BA.debugLineNum = 424;BA.debugLine="bCampos(3) = \"\"";
_bcampos[(int) (3)] = "";
 //BA.debugLineNum = 425;BA.debugLine="bCampos(4) = \"\"";
_bcampos[(int) (4)] = "";
 //BA.debugLineNum = 426;BA.debugLine="bCampos(5) = \"\"";
_bcampos[(int) (5)] = "";
 //BA.debugLineNum = 427;BA.debugLine="bCampos(6) = \"\"";
_bcampos[(int) (6)] = "";
 //BA.debugLineNum = 429;BA.debugLine="For n=0 To aCampos.Length -1";
{
final int step38 = 1;
final int limit38 = (int) (_acampos.length-1);
_n = (int) (0) ;
for (;_n <= limit38 ;_n = _n + step38 ) {
 //BA.debugLineNum = 430;BA.debugLine="bCampos(n) = aCampos(n)";
_bcampos[_n] = _acampos[_n];
 }
};
 //BA.debugLineNum = 433;BA.debugLine="cu.InsertContact(  bCampos(2), bCampos(3) )";
_cu._insertcontact /*br.tssistemas.contatos.contactsutils._cucontact*/ (_bcampos[(int) (2)],_bcampos[(int) (3)]);
 //BA.debugLineNum = 435;BA.debugLine="lbl.Text =   i & \" de \" & nReg & CRLF & \"\" &";
mostCurrent._lbl.setText(BA.ObjectToCharSequence(BA.NumberToString(_i)+" de "+BA.NumberToString(_nreg)+anywheresoftware.b4a.keywords.Common.CRLF+""+anywheresoftware.b4a.keywords.Common.NumberFormat2((_i/(double)_nreg)*100,(int) (0),(int) (3),(int) (3),anywheresoftware.b4a.keywords.Common.False)+" %"));
 //BA.debugLineNum = 436;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 }
};
 };
 } 
       catch (Exception e47) {
			processBA.setLastException(e47); //BA.debugLineNum = 445;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("4983117",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 451;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 22;BA.debugLine="Private cu As ContactsUtils";
_cu = new br.tssistemas.contatos.contactsutils();
 //BA.debugLineNum = 23;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
}
