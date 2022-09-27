package br.tssistemas.contatos;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class contactsutils extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "br.tssistemas.contatos.contactsutils");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", br.tssistemas.contatos.contactsutils.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _mailtypes = null;
public anywheresoftware.b4a.objects.collections.Map _phonetypes = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _datauri = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _contacturi = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _rawcontacturi = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _groupcontacturi = null;
public br.tssistemas.contatos.main _main = null;
public static class _cucontact{
public boolean IsInitialized;
public long Id;
public String DisplayName;
public String GroupID;
public void Initialize() {
IsInitialized = true;
Id = 0L;
DisplayName = "";
GroupID = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cuemail{
public boolean IsInitialized;
public String Email;
public String EmailType;
public void Initialize() {
IsInitialized = true;
Email = "";
EmailType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cuphone{
public boolean IsInitialized;
public String Number;
public String PhoneType;
public void Initialize() {
IsInitialized = true;
Number = "";
PhoneType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cugroup{
public boolean IsInitialized;
public long Id;
public String Title;
public void Initialize() {
IsInitialized = true;
Id = 0L;
Title = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _addemail(long _id,String _email,String _emailtype) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
 //BA.debugLineNum = 260;BA.debugLine="Public Sub AddEmail(Id As Long, Email As String, E";
 //BA.debugLineNum = 261;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 262;BA.debugLine="v.Initialize";
_v.Initialize();
 //BA.debugLineNum = 263;BA.debugLine="v.PutString(\"data1\", Email)";
_v.PutString("data1",_email);
 //BA.debugLineNum = 264;BA.debugLine="v.PutInteger(\"data2\", GetKeyFromValue(mailTypes,";
_v.PutInteger("data2",_getkeyfromvalue(_mailtypes,_emailtype,(int) (3)));
 //BA.debugLineNum = 265;BA.debugLine="SetData(\"vnd.android.cursor.item/email_v2\", v, Id";
_setdata("vnd.android.cursor.item/email_v2",_v,_id,__c.False);
 //BA.debugLineNum = 266;BA.debugLine="End Sub";
return "";
}
public String  _addphone(long _id,String _phonenumber,String _phonetype) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
 //BA.debugLineNum = 270;BA.debugLine="Public Sub AddPhone(Id As Long, PhoneNumber As Str";
 //BA.debugLineNum = 271;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 272;BA.debugLine="v.Initialize";
_v.Initialize();
 //BA.debugLineNum = 273;BA.debugLine="v.PutString(\"data1\", PhoneNumber)";
_v.PutString("data1",_phonenumber);
 //BA.debugLineNum = 274;BA.debugLine="v.PutInteger(\"data2\", GetKeyFromValue(phoneTypes,";
_v.PutInteger("data2",_getkeyfromvalue(_phonetypes,_phonetype,(int) (7)));
 //BA.debugLineNum = 275;BA.debugLine="SetData(\"vnd.android.cursor.item/phone_v2\", v, Id";
_setdata("vnd.android.cursor.item/phone_v2",_v,_id,__c.False);
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Type cuContact (Id As Long, DisplayName As String";
;
 //BA.debugLineNum = 5;BA.debugLine="Type cuEmail (Email As String, EmailType As Strin";
;
 //BA.debugLineNum = 6;BA.debugLine="Type cuPhone (Number As String, PhoneType As Stri";
;
 //BA.debugLineNum = 7;BA.debugLine="Type cuGroup (Id As Long, Title As String)";
;
 //BA.debugLineNum = 8;BA.debugLine="Private mailTypes, phoneTypes As Map";
_mailtypes = new anywheresoftware.b4a.objects.collections.Map();
_phonetypes = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 9;BA.debugLine="Private cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private dataUri, contactUri, rawContactUri, group";
_datauri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_contacturi = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_rawcontacturi = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_groupcontacturi = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _deletecontact(long _id) throws Exception{
 //BA.debugLineNum = 338;BA.debugLine="Public Sub DeleteContact(Id As Long)";
 //BA.debugLineNum = 339;BA.debugLine="cr.Delete(rawContactUri, \"contact_id = ?\", Array";
_cr.Delete((android.net.Uri)(_rawcontacturi.getObject()),"contact_id = ?",new String[]{BA.NumberToString(_id)});
 //BA.debugLineNum = 340;BA.debugLine="End Sub";
return "";
}
public String  _deletedata(String _mime,String _data1value,long _id) throws Exception{
 //BA.debugLineNum = 301;BA.debugLine="Private Sub DeleteData(Mime As String, Data1Value";
 //BA.debugLineNum = 302;BA.debugLine="cr.Delete(dataUri, \"mimetype = ? AND data1 = ? AN";
_cr.Delete((android.net.Uri)(_datauri.getObject()),"mimetype = ? AND data1 = ? AND contact_id = ?",new String[]{_mime,_data1value,BA.NumberToString(_id)});
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public String  _deleteemail(long _id,String _email) throws Exception{
 //BA.debugLineNum = 284;BA.debugLine="Public Sub DeleteEmail(Id As Long,Email As String)";
 //BA.debugLineNum = 285;BA.debugLine="DeleteData(\"vnd.android.cursor.item/email_v2\", Em";
_deletedata("vnd.android.cursor.item/email_v2",_email,_id);
 //BA.debugLineNum = 286;BA.debugLine="End Sub";
return "";
}
public String  _deletephone(long _id,String _phonenumber) throws Exception{
 //BA.debugLineNum = 279;BA.debugLine="Public Sub DeletePhone(Id As Long, PhoneNumber As";
 //BA.debugLineNum = 280;BA.debugLine="DeleteData(\"vnd.android.cursor.item/phone_v2\", Ph";
_deletedata("vnd.android.cursor.item/phone_v2",_phonenumber,_id);
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _findallcontacts(boolean _visibleonly) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Public Sub FindAllContacts(VisibleOnly As Boolean)";
 //BA.debugLineNum = 90;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/name","data1","null","<>",__c.True,_visibleonly);
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findallgroups() throws Exception{
String[] _projection = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
anywheresoftware.b4a.objects.collections.List _ret = null;
int _i = 0;
br.tssistemas.contatos.contactsutils._cugroup _grp = null;
 //BA.debugLineNum = 396;BA.debugLine="Public Sub FindAllGroups As List";
 //BA.debugLineNum = 397;BA.debugLine="Dim Projection(2) As String = Array As String(\"_i";
_projection = new String[]{"_id","title"};
 //BA.debugLineNum = 398;BA.debugLine="Dim crsr As Cursor = cr.Query(groupContactUri, Pr";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_groupcontacturi,_projection,"title <> ?",new String[]{"null"},"");
 //BA.debugLineNum = 400;BA.debugLine="Dim ret As List";
_ret = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 401;BA.debugLine="ret.Initialize";
_ret.Initialize();
 //BA.debugLineNum = 402;BA.debugLine="For i = 0 To crsr.RowCount - 1";
{
final int step5 = 1;
final int limit5 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 403;BA.debugLine="crsr.Position = i";
_crsr.setPosition(_i);
 //BA.debugLineNum = 404;BA.debugLine="Dim Grp As cuGroup";
_grp = new br.tssistemas.contatos.contactsutils._cugroup();
 //BA.debugLineNum = 405;BA.debugLine="Grp.Id    = crsr.GetLong(\"_id\")";
_grp.Id /*long*/  = _crsr.GetLong("_id");
 //BA.debugLineNum = 406;BA.debugLine="Grp.Title = crsr.GetString(\"title\")";
_grp.Title /*String*/  = _crsr.GetString("title");
 //BA.debugLineNum = 407;BA.debugLine="ret.Add(Grp)";
_ret.Add((Object)(_grp));
 }
};
 //BA.debugLineNum = 409;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 410;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 411;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbygroupid(long _groupid,boolean _exact,boolean _visibleonly) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub FindContactsByGroupID(GroupID As Long,";
 //BA.debugLineNum = 61;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/group_membership","data1",BA.NumberToString(_groupid),"=",_exact,_visibleonly);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbymail(String _mail,boolean _exact,boolean _visibleonly) throws Exception{
 //BA.debugLineNum = 66;BA.debugLine="Public Sub FindContactsByMail(Mail As String, Exac";
 //BA.debugLineNum = 67;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/email_v2","data1",_mail,"=",_exact,_visibleonly);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbyname(String _name,boolean _exact,boolean _visibleonly) throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Public Sub FindContactsByName(Name As String, Exac";
 //BA.debugLineNum = 57;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/name","data1",_name,"=",_exact,_visibleonly);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbynotes(String _note,boolean _exact,boolean _visibleonly) throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Public Sub FindContactsByNotes(Note As String, Exa";
 //BA.debugLineNum = 72;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/note","data1",_note,"=",_exact,_visibleonly);
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbyphone(String _phonenumber,boolean _exact,boolean _visibleonly) throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Public Sub FindContactsByPhone(PhoneNumber As Stri";
 //BA.debugLineNum = 77;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/phone_v2","data1",_phonenumber,"=",_exact,_visibleonly);
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbystarred(boolean _starred) throws Exception{
String _value = "";
 //BA.debugLineNum = 83;BA.debugLine="Public Sub FindContactsByStarred(Starred As Boolea";
 //BA.debugLineNum = 84;BA.debugLine="Dim value As String";
_value = "";
 //BA.debugLineNum = 85;BA.debugLine="If Starred Then value = \"1\" Else value = \"0\"";
if (_starred) { 
_value = "1";}
else {
_value = "0";};
 //BA.debugLineNum = 86;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/name","starred",_value,"=",__c.True,__c.True);
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsidfromdata(String _mime,String _datacolumn,String _value,String _operator,boolean _exact,boolean _visibleonly) throws Exception{
String _selection = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
anywheresoftware.b4a.objects.collections.List _res = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
br.tssistemas.contatos.contactsutils._cucontact _cu = null;
 //BA.debugLineNum = 125;BA.debugLine="Private Sub FindContactsIdFromData (Mime As String";
 //BA.debugLineNum = 128;BA.debugLine="If Not(Exact) Then";
if (__c.Not(_exact)) { 
 //BA.debugLineNum = 129;BA.debugLine="Operator = \"LIKE\"";
_operator = "LIKE";
 //BA.debugLineNum = 130;BA.debugLine="Value = \"%\" & Value & \"%\"";
_value = "%"+_value+"%";
 };
 //BA.debugLineNum = 133;BA.debugLine="Dim selection As String = \"mimetype = ? AND \" & D";
_selection = "mimetype = ? AND "+_datacolumn+" "+_operator+" ? ";
 //BA.debugLineNum = 135;BA.debugLine="If VisibleOnly Then selection = selection & \" AND";
if (_visibleonly) { 
_selection = _selection+" AND in_visible_group = 1";};
 //BA.debugLineNum = 137;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_datauri,new String[]{"contact_id","display_name","data1"},_selection,new String[]{_mime,_value},"");
 //BA.debugLineNum = 138;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 139;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 141;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 142;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 144;BA.debugLine="For i = 0 To crsr.RowCount - 1";
{
final int step12 = 1;
final int limit12 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
 //BA.debugLineNum = 145;BA.debugLine="crsr.Position = i";
_crsr.setPosition(_i);
 //BA.debugLineNum = 146;BA.debugLine="Dim cu As cuContact";
_cu = new br.tssistemas.contatos.contactsutils._cucontact();
 //BA.debugLineNum = 147;BA.debugLine="cu.Initialize";
_cu.Initialize();
 //BA.debugLineNum = 148;BA.debugLine="cu.Id = crsr.GetLong(\"contact_id\")";
_cu.Id /*long*/  = _crsr.GetLong("contact_id");
 //BA.debugLineNum = 149;BA.debugLine="cu.DisplayName = crsr.GetString(\"display_name\")";
_cu.DisplayName /*String*/  = _crsr.GetString("display_name");
 //BA.debugLineNum = 150;BA.debugLine="cu.GroupID= crsr.GetString(\"data1\")";
_cu.GroupID /*String*/  = _crsr.GetString("data1");
 //BA.debugLineNum = 151;BA.debugLine="If m.ContainsKey(cu.Id) Then Continue";
if (_m.ContainsKey((Object)(_cu.Id /*long*/ ))) { 
if (true) continue;};
 //BA.debugLineNum = 152;BA.debugLine="m.Put(cu.Id, Null)";
_m.Put((Object)(_cu.Id /*long*/ ),__c.Null);
 //BA.debugLineNum = 153;BA.debugLine="res.Add(cu)";
_res.Add((Object)(_cu));
 }
};
 //BA.debugLineNum = 159;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 160;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactswithphotos() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Public Sub FindContactsWithPhotos As List";
 //BA.debugLineNum = 94;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return _findcontactsidfromdata("vnd.android.cursor.item/photo","data15","null","<>",__c.True,__c.False);
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return null;
}
public long  _findgroupid(String _name) throws Exception{
long _retgrp = 0L;
String[] _projection = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
 //BA.debugLineNum = 383;BA.debugLine="Public Sub FindGroupID(Name As String) As Long";
 //BA.debugLineNum = 384;BA.debugLine="Dim retGrp As Long = 0";
_retgrp = (long) (0);
 //BA.debugLineNum = 386;BA.debugLine="Dim Projection(2) As String = Array As String(\"_i";
_projection = new String[]{"_id","title"};
 //BA.debugLineNum = 387;BA.debugLine="Dim crsr As Cursor = cr.Query(groupContactUri, Pr";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_groupcontacturi,_projection,"title = ?",new String[]{_name},"");
 //BA.debugLineNum = 388;BA.debugLine="If crsr.RowCount > 0 Then";
if (_crsr.getRowCount()>0) { 
 //BA.debugLineNum = 389;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
 //BA.debugLineNum = 390;BA.debugLine="retGrp = crsr.GetLong(\"_id\")";
_retgrp = _crsr.GetLong("_id");
 };
 //BA.debugLineNum = 392;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 393;BA.debugLine="Return retGrp";
if (true) return _retgrp;
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
return 0L;
}
public String  _findidbyphone(String _phonenumber,boolean _exact,boolean _visibleonly) throws Exception{
long _id = 0L;
String _operator = "";
String _mime = "";
String _selection = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
int _i = 0;
 //BA.debugLineNum = 99;BA.debugLine="Public Sub FindIdByPhone(PhoneNumber As String, Ex";
 //BA.debugLineNum = 101;BA.debugLine="Dim Id As Long";
_id = 0L;
 //BA.debugLineNum = 102;BA.debugLine="Dim Operator As String";
_operator = "";
 //BA.debugLineNum = 104;BA.debugLine="If Not(Exact) Then";
if (__c.Not(_exact)) { 
 //BA.debugLineNum = 105;BA.debugLine="Operator = \"LIKE\"";
_operator = "LIKE";
 //BA.debugLineNum = 106;BA.debugLine="PhoneNumber = \"%\" & PhoneNumber & \"%\"";
_phonenumber = "%"+_phonenumber+"%";
 };
 //BA.debugLineNum = 109;BA.debugLine="Dim Mime As String = \"vnd.android.cursor.item/pho";
_mime = "vnd.android.cursor.item/phone_v2";
 //BA.debugLineNum = 110;BA.debugLine="Dim selection As String = \"mimetype = ? AND \" & \"";
_selection = "mimetype = ? AND "+"data1"+" "+_operator+" ? ";
 //BA.debugLineNum = 112;BA.debugLine="If VisibleOnly Then selection = selection & \" AND";
if (_visibleonly) { 
_selection = _selection+" AND in_visible_group = 1";};
 //BA.debugLineNum = 113;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_datauri,new String[]{"contact_id","display_name","data1"},_selection,new String[]{_mime,_phonenumber},"");
 //BA.debugLineNum = 115;BA.debugLine="For i = 0 To crsr.RowCount - 1";
{
final int step11 = 1;
final int limit11 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit11 ;_i = _i + step11 ) {
 //BA.debugLineNum = 116;BA.debugLine="crsr.Position = i";
_crsr.setPosition(_i);
 //BA.debugLineNum = 117;BA.debugLine="Id = crsr.GetLong(\"contact_id\")";
_id = _crsr.GetLong("contact_id");
 }
};
 //BA.debugLineNum = 119;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 121;BA.debugLine="Return( Id )";
if (true) return BA.NumberToString((_id));
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getdata(String _mime,String[] _datacolumns,long _id,boolean[] _blobs) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
anywheresoftware.b4a.objects.collections.List _res = null;
int _i = 0;
Object[] _row = null;
int _c = 0;
 //BA.debugLineNum = 228;BA.debugLine="Private Sub GetData(Mime As String, DataColumns()";
 //BA.debugLineNum = 229;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, DataColumn";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_datauri,_datacolumns,"mimetype = ? AND contact_id = ?",new String[]{_mime,BA.NumberToString(_id)},"");
 //BA.debugLineNum = 231;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 232;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 233;BA.debugLine="For i = 0 To crsr.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 234;BA.debugLine="crsr.Position = i";
_crsr.setPosition(_i);
 //BA.debugLineNum = 235;BA.debugLine="Dim row(DataColumns.Length) As Object";
_row = new Object[_datacolumns.length];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
 //BA.debugLineNum = 236;BA.debugLine="For c = 0 To DataColumns.Length - 1";
{
final int step7 = 1;
final int limit7 = (int) (_datacolumns.length-1);
_c = (int) (0) ;
for (;_c <= limit7 ;_c = _c + step7 ) {
 //BA.debugLineNum = 237;BA.debugLine="If Blobs <> Null And Blobs(c) = True Then";
if (_blobs!= null && _blobs[_c]==__c.True) { 
 //BA.debugLineNum = 238;BA.debugLine="row(c) = crsr.GetBlob2(c)";
_row[_c] = (Object)(_crsr.GetBlob2(_c));
 }else {
 //BA.debugLineNum = 240;BA.debugLine="row(c) = crsr.GetString2(c)";
_row[_c] = (Object)(_crsr.GetString2(_c));
 };
 }
};
 //BA.debugLineNum = 243;BA.debugLine="res.Add(row)";
_res.Add((Object)(_row));
 }
};
 //BA.debugLineNum = 245;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 246;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getemails(long _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _res = null;
Object[] _obj = null;
br.tssistemas.contatos.contactsutils._cuemail _e = null;
 //BA.debugLineNum = 166;BA.debugLine="Public Sub GetEmails(Id As Long) As List";
 //BA.debugLineNum = 167;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 168;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 169;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
{
final anywheresoftware.b4a.BA.IterableList group3 = _getdata("vnd.android.cursor.item/email_v2",new String[]{"data1","data2"},_id,(boolean[])(__c.Null));
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (Object[])(group3.Get(index3));
 //BA.debugLineNum = 170;BA.debugLine="Dim e As cuEmail";
_e = new br.tssistemas.contatos.contactsutils._cuemail();
 //BA.debugLineNum = 171;BA.debugLine="e.Initialize";
_e.Initialize();
 //BA.debugLineNum = 172;BA.debugLine="e.Email = obj(0)";
_e.Email /*String*/  = BA.ObjectToString(_obj[(int) (0)]);
 //BA.debugLineNum = 173;BA.debugLine="e.EmailType = mailTypes.Get(obj(1))";
_e.EmailType /*String*/  = BA.ObjectToString(_mailtypes.Get(_obj[(int) (1)]));
 //BA.debugLineNum = 174;BA.debugLine="res.Add(e)";
_res.Add((Object)(_e));
 }
};
 //BA.debugLineNum = 176;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return null;
}
public int  _getkeyfromvalue(anywheresoftware.b4a.objects.collections.Map _m,String _v,int _defaultvalue) throws Exception{
int _t = 0;
int _i = 0;
 //BA.debugLineNum = 290;BA.debugLine="Private Sub GetKeyFromValue(m As Map, v As String,";
 //BA.debugLineNum = 291;BA.debugLine="Dim t As Int = defaultValue";
_t = _defaultvalue;
 //BA.debugLineNum = 292;BA.debugLine="For i = 0 To m.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_m.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
 //BA.debugLineNum = 293;BA.debugLine="If m.GetValueAt(i) = v Then";
if ((_m.GetValueAt(_i)).equals((Object)(_v))) { 
 //BA.debugLineNum = 294;BA.debugLine="t = m.GetKeyAt(i)";
_t = (int)(BA.ObjectToNumber(_m.GetKeyAt(_i)));
 //BA.debugLineNum = 295;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 298;BA.debugLine="Return t";
if (true) return _t;
 //BA.debugLineNum = 299;BA.debugLine="End Sub";
return 0;
}
public String  _getnote(long _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _raw = null;
Object[] _obj = null;
 //BA.debugLineNum = 194;BA.debugLine="Public Sub GetNote(id As Long) As String";
 //BA.debugLineNum = 195;BA.debugLine="Dim raw As List = GetData(\"vnd.android.cursor.ite";
_raw = new anywheresoftware.b4a.objects.collections.List();
_raw = _getdata("vnd.android.cursor.item/note",new String[]{"data1"},_id,(boolean[])(__c.Null));
 //BA.debugLineNum = 196;BA.debugLine="If raw.Size = 0 Then Return \"\"";
if (_raw.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 197;BA.debugLine="Dim obj() As Object = raw.Get(0)";
_obj = (Object[])(_raw.Get((int) (0)));
 //BA.debugLineNum = 198;BA.debugLine="Return obj(0)";
if (true) return BA.ObjectToString(_obj[(int) (0)]);
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getphones(long _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _res = null;
Object[] _obj = null;
br.tssistemas.contatos.contactsutils._cuphone _p = null;
 //BA.debugLineNum = 180;BA.debugLine="Public Sub GetPhones(id As Long) As List";
 //BA.debugLineNum = 181;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 182;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 183;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
{
final anywheresoftware.b4a.BA.IterableList group3 = _getdata("vnd.android.cursor.item/phone_v2",new String[]{"data1","data2"},_id,(boolean[])(__c.Null));
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (Object[])(group3.Get(index3));
 //BA.debugLineNum = 184;BA.debugLine="Dim p As cuPhone";
_p = new br.tssistemas.contatos.contactsutils._cuphone();
 //BA.debugLineNum = 185;BA.debugLine="p.Initialize";
_p.Initialize();
 //BA.debugLineNum = 186;BA.debugLine="p.Number = obj(0)";
_p.Number /*String*/  = BA.ObjectToString(_obj[(int) (0)]);
 //BA.debugLineNum = 187;BA.debugLine="p.PhoneType = phoneTypes.Get(obj(1))";
_p.PhoneType /*String*/  = BA.ObjectToString(_phonetypes.Get(_obj[(int) (1)]));
 //BA.debugLineNum = 188;BA.debugLine="res.Add(p)";
_res.Add((Object)(_p));
 }
};
 //BA.debugLineNum = 190;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 191;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getphoto(long _id) throws Exception{
anywheresoftware.b4a.objects.collections.List _raw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
Object[] _obj = null;
byte[] _bytes = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 202;BA.debugLine="Public Sub GetPhoto(Id As Long) As Bitmap";
 //BA.debugLineNum = 203;BA.debugLine="Dim raw As List = GetData(\"vnd.android.cursor.ite";
_raw = new anywheresoftware.b4a.objects.collections.List();
_raw = _getdata("vnd.android.cursor.item/photo",new String[]{"data15"},_id,new boolean[]{__c.True});
 //BA.debugLineNum = 204;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 205;BA.debugLine="If raw.Size > 0 Then";
if (_raw.getSize()>0) { 
 //BA.debugLineNum = 206;BA.debugLine="Dim obj() As Object = raw.Get(0)";
_obj = (Object[])(_raw.Get((int) (0)));
 //BA.debugLineNum = 207;BA.debugLine="Dim bytes() As Byte = obj(0)";
_bytes = (byte[])(_obj[(int) (0)]);
 //BA.debugLineNum = 208;BA.debugLine="If bytes <> Null Then";
if (_bytes!= null) { 
 //BA.debugLineNum = 209;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 210;BA.debugLine="In.InitializeFromBytesArray(bytes, 0, bytes.Len";
_in.InitializeFromBytesArray(_bytes,(int) (0),_bytes.length);
 //BA.debugLineNum = 211;BA.debugLine="bmp.Initialize2(In)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
 //BA.debugLineNum = 212;BA.debugLine="In.Close";
_in.Close();
 };
 };
 //BA.debugLineNum = 215;BA.debugLine="Return bmp";
if (true) return _bmp;
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return null;
}
public boolean  _getstarred(long _id) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
boolean _starred = false;
 //BA.debugLineNum = 219;BA.debugLine="Public Sub GetStarred(Id As Long) As Boolean";
 //BA.debugLineNum = 220;BA.debugLine="Dim crsr As Cursor = cr.Query(contactUri, Array A";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_contacturi,new String[]{"starred"},"_id = ?",new String[]{BA.NumberToString(_id)},"");
 //BA.debugLineNum = 221;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
 //BA.debugLineNum = 222;BA.debugLine="Dim starred As Boolean = crsr.GetInt(\"starred\") =";
_starred = _crsr.GetInt("starred")==1;
 //BA.debugLineNum = 223;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 224;BA.debugLine="Return starred";
if (true) return _starred;
 //BA.debugLineNum = 225;BA.debugLine="End Sub";
return false;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 13;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 15;BA.debugLine="dataUri.Parse(\"content://com.android.contacts/dat";
_datauri.Parse("content://com.android.contacts/data");
 //BA.debugLineNum = 16;BA.debugLine="contactUri.Parse(\"content://com.android.contacts/";
_contacturi.Parse("content://com.android.contacts/contacts");
 //BA.debugLineNum = 17;BA.debugLine="rawContactUri.Parse(\"content://com.android.contac";
_rawcontacturi.Parse("content://com.android.contacts/raw_contacts");
 //BA.debugLineNum = 18;BA.debugLine="groupContactUri.Parse(\"content://com.android.cont";
_groupcontacturi.Parse("content://com.android.contacts/groups");
 //BA.debugLineNum = 21;BA.debugLine="cr.Initialize(\"cr\")";
_cr.Initialize("cr");
 //BA.debugLineNum = 22;BA.debugLine="mailTypes.Initialize";
_mailtypes.Initialize();
 //BA.debugLineNum = 24;BA.debugLine="mailTypes.Put(\"1\", \"home\")";
_mailtypes.Put((Object)("1"),(Object)("home"));
 //BA.debugLineNum = 25;BA.debugLine="mailTypes.Put(\"2\", \"work\")";
_mailtypes.Put((Object)("2"),(Object)("work"));
 //BA.debugLineNum = 26;BA.debugLine="mailTypes.Put(\"3\", \"other\")";
_mailtypes.Put((Object)("3"),(Object)("other"));
 //BA.debugLineNum = 27;BA.debugLine="mailTypes.Put(\"4\", \"mobile\")";
_mailtypes.Put((Object)("4"),(Object)("mobile"));
 //BA.debugLineNum = 29;BA.debugLine="phoneTypes.Initialize";
_phonetypes.Initialize();
 //BA.debugLineNum = 30;BA.debugLine="phoneTypes.Put(\"1\", \"home\")";
_phonetypes.Put((Object)("1"),(Object)("home"));
 //BA.debugLineNum = 31;BA.debugLine="phoneTypes.Put(\"2\", \"mobile\")";
_phonetypes.Put((Object)("2"),(Object)("mobile"));
 //BA.debugLineNum = 32;BA.debugLine="phoneTypes.Put(\"3\", \"work\")";
_phonetypes.Put((Object)("3"),(Object)("work"));
 //BA.debugLineNum = 33;BA.debugLine="phoneTypes.Put(\"4\", \"fax_work\")";
_phonetypes.Put((Object)("4"),(Object)("fax_work"));
 //BA.debugLineNum = 34;BA.debugLine="phoneTypes.Put(\"5\", \"fax_home\")";
_phonetypes.Put((Object)("5"),(Object)("fax_home"));
 //BA.debugLineNum = 35;BA.debugLine="phoneTypes.Put(\"6\", \"pager\")";
_phonetypes.Put((Object)("6"),(Object)("pager"));
 //BA.debugLineNum = 36;BA.debugLine="phoneTypes.Put(\"7\", \"other\")";
_phonetypes.Put((Object)("7"),(Object)("other"));
 //BA.debugLineNum = 37;BA.debugLine="phoneTypes.Put(\"8\", \"callback\")";
_phonetypes.Put((Object)("8"),(Object)("callback"));
 //BA.debugLineNum = 38;BA.debugLine="phoneTypes.Put(\"9\", \"car\")";
_phonetypes.Put((Object)("9"),(Object)("car"));
 //BA.debugLineNum = 39;BA.debugLine="phoneTypes.Put(\"10\", \"company_main\")";
_phonetypes.Put((Object)("10"),(Object)("company_main"));
 //BA.debugLineNum = 40;BA.debugLine="phoneTypes.Put(\"11\", \"isdn\")";
_phonetypes.Put((Object)("11"),(Object)("isdn"));
 //BA.debugLineNum = 41;BA.debugLine="phoneTypes.Put(\"12\", \"main\")";
_phonetypes.Put((Object)("12"),(Object)("main"));
 //BA.debugLineNum = 42;BA.debugLine="phoneTypes.Put(\"13\", \"other_fax\")";
_phonetypes.Put((Object)("13"),(Object)("other_fax"));
 //BA.debugLineNum = 43;BA.debugLine="phoneTypes.Put(\"14\", \"radio\")";
_phonetypes.Put((Object)("14"),(Object)("radio"));
 //BA.debugLineNum = 44;BA.debugLine="phoneTypes.Put(\"15\", \"telex\")";
_phonetypes.Put((Object)("15"),(Object)("telex"));
 //BA.debugLineNum = 45;BA.debugLine="phoneTypes.Put(\"16\", \"tty_tdd\")";
_phonetypes.Put((Object)("16"),(Object)("tty_tdd"));
 //BA.debugLineNum = 46;BA.debugLine="phoneTypes.Put(\"17\", \"work_mobile\")";
_phonetypes.Put((Object)("17"),(Object)("work_mobile"));
 //BA.debugLineNum = 47;BA.debugLine="phoneTypes.Put(\"18\", \"work_pager\")";
_phonetypes.Put((Object)("18"),(Object)("work_pager"));
 //BA.debugLineNum = 48;BA.debugLine="phoneTypes.Put(\"19\", \"assistant\")";
_phonetypes.Put((Object)("19"),(Object)("assistant"));
 //BA.debugLineNum = 49;BA.debugLine="phoneTypes.Put(\"20\", \"mms\")";
_phonetypes.Put((Object)("20"),(Object)("mms"));
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public br.tssistemas.contatos.contactsutils._cucontact  _insertcontact(String _name,String _phone) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _rawuri = null;
long _rawcontactid = 0L;
br.tssistemas.contatos.contactsutils._cucontact _cu = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
 //BA.debugLineNum = 343;BA.debugLine="Public Sub InsertContact(Name As String, Phone As";
 //BA.debugLineNum = 344;BA.debugLine="Dim values As ContentValues";
_values = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 345;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 346;BA.debugLine="values.PutNull(\"account_name\")";
_values.PutNull("account_name");
 //BA.debugLineNum = 347;BA.debugLine="values.PutNull(\"account_type\")";
_values.PutNull("account_type");
 //BA.debugLineNum = 348;BA.debugLine="Dim rawUri As Uri = cr.Insert(rawContactUri, valu";
_rawuri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_rawuri = _cr.Insert(_rawcontacturi,(android.content.ContentValues)(_values.getObject()));
 //BA.debugLineNum = 349;BA.debugLine="Dim rawContactId As Long = rawUri.ParseId";
_rawcontactid = _rawuri.ParseId();
 //BA.debugLineNum = 351;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 352;BA.debugLine="values.PutLong(\"raw_contact_id\", rawContactId)";
_values.PutLong("raw_contact_id",_rawcontactid);
 //BA.debugLineNum = 353;BA.debugLine="values.PutString(\"mimetype\", \"vnd.android.cursor.";
_values.PutString("mimetype","vnd.android.cursor.item/phone_v2");
 //BA.debugLineNum = 354;BA.debugLine="values.PutString(\"data1\", Phone)";
_values.PutString("data1",_phone);
 //BA.debugLineNum = 355;BA.debugLine="cr.Insert(dataUri, values)";
_cr.Insert(_datauri,(android.content.ContentValues)(_values.getObject()));
 //BA.debugLineNum = 357;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 358;BA.debugLine="values.PutLong(\"raw_contact_id\", rawContactId)";
_values.PutLong("raw_contact_id",_rawcontactid);
 //BA.debugLineNum = 359;BA.debugLine="values.PutString(\"mimetype\", \"vnd.android.cursor.";
_values.PutString("mimetype","vnd.android.cursor.item/name");
 //BA.debugLineNum = 360;BA.debugLine="values.PutString(\"data1\", Name)";
_values.PutString("data1",_name);
 //BA.debugLineNum = 361;BA.debugLine="cr.Insert(dataUri, values)";
_cr.Insert(_datauri,(android.content.ContentValues)(_values.getObject()));
 //BA.debugLineNum = 362;BA.debugLine="Dim cu As cuContact";
_cu = new br.tssistemas.contatos.contactsutils._cucontact();
 //BA.debugLineNum = 363;BA.debugLine="cu.Initialize";
_cu.Initialize();
 //BA.debugLineNum = 364;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_datauri,new String[]{"contact_id","display_name"},"raw_contact_id = ?",new String[]{BA.NumberToString(_rawcontactid)},"");
 //BA.debugLineNum = 365;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
 //BA.debugLineNum = 366;BA.debugLine="cu.DisplayName = crsr.GetString(\"display_name\")";
_cu.DisplayName /*String*/  = _crsr.GetString("display_name");
 //BA.debugLineNum = 367;BA.debugLine="cu.Id = crsr.GetLong(\"contact_id\")";
_cu.Id /*long*/  = _crsr.GetLong("contact_id");
 //BA.debugLineNum = 368;BA.debugLine="Return cu";
if (true) return _cu;
 //BA.debugLineNum = 370;BA.debugLine="End Sub";
return null;
}
public String  _insertgroup(String _name) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values = null;
 //BA.debugLineNum = 374;BA.debugLine="Public Sub InsertGroup(Name As String)";
 //BA.debugLineNum = 375;BA.debugLine="Dim values As ContentValues";
_values = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 377;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 378;BA.debugLine="values.PutString(\"title\", Name)";
_values.PutString("title",_name);
 //BA.debugLineNum = 379;BA.debugLine="cr.Insert(groupContactUri, values)";
_cr.Insert(_groupcontacturi,(android.content.ContentValues)(_values.getObject()));
 //BA.debugLineNum = 380;BA.debugLine="End Sub";
return "";
}
public String  _printcursor(anywheresoftware.b4a.sql.SQL.CursorWrapper _c) throws Exception{
int _r = 0;
int _col = 0;
 //BA.debugLineNum = 415;BA.debugLine="Private Sub printCursor(c As Cursor) 'ignore";
 //BA.debugLineNum = 416;BA.debugLine="For r = 0 To c.RowCount - 1";
{
final int step1 = 1;
final int limit1 = (int) (_c.getRowCount()-1);
_r = (int) (0) ;
for (;_r <= limit1 ;_r = _r + step1 ) {
 //BA.debugLineNum = 417;BA.debugLine="c.Position = r";
_c.setPosition(_r);
 //BA.debugLineNum = 418;BA.debugLine="For col = 0 To c.ColumnCount - 1";
{
final int step3 = 1;
final int limit3 = (int) (_c.getColumnCount()-1);
_col = (int) (0) ;
for (;_col <= limit3 ;_col = _col + step3 ) {
 //BA.debugLineNum = 419;BA.debugLine="Try";
try { //BA.debugLineNum = 420;BA.debugLine="Log(c.GetColumnName(col) & \": \" & c.GetString2";
__c.LogImpl("43145733",_c.GetColumnName(_col)+": "+_c.GetString2(_col),0);
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 422;BA.debugLine="Log(c.GetColumnName(col) & \": \" & LastExceptio";
__c.LogImpl("43145735",_c.GetColumnName(_col)+": "+BA.ObjectToString(__c.LastException(getActivityBA())),0);
 };
 }
};
 //BA.debugLineNum = 425;BA.debugLine="Log(\"***************\")";
__c.LogImpl("43145738","***************",0);
 }
};
 //BA.debugLineNum = 427;BA.debugLine="End Sub";
return "";
}
public String  _setdata(String _mime,anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values,long _id,boolean _update) throws Exception{
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
 //BA.debugLineNum = 306;BA.debugLine="Private Sub SetData(Mime As String, Values As Cont";
 //BA.debugLineNum = 308;BA.debugLine="If Update Then";
if (_update) { 
 //BA.debugLineNum = 309;BA.debugLine="cr.Update(dataUri, Values, \"mimetype = ? AND con";
_cr.Update((android.net.Uri)(_datauri.getObject()),(android.content.ContentValues)(_values.getObject()),"mimetype = ? AND contact_id = ?",new String[]{_mime,BA.NumberToString(_id)});
 }else {
 //BA.debugLineNum = 312;BA.debugLine="Dim crsr As Cursor = cr.Query(contactUri, Array";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_contacturi,new String[]{"name_raw_contact_id"},"_id = ?",new String[]{BA.NumberToString(_id)},"");
 //BA.debugLineNum = 313;BA.debugLine="If crsr.RowCount = 0 Then";
if (_crsr.getRowCount()==0) { 
 //BA.debugLineNum = 314;BA.debugLine="Log(\"Error getting raw_contact_id\")";
__c.LogImpl("42686984","Error getting raw_contact_id",0);
 //BA.debugLineNum = 315;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 316;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 319;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
 //BA.debugLineNum = 320;BA.debugLine="Values.PutString(\"raw_contact_id\", crsr.GetStrin";
_values.PutString("raw_contact_id",_crsr.GetString("name_raw_contact_id"));
 //BA.debugLineNum = 321;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 322;BA.debugLine="Values.PutString(\"mimetype\", Mime)";
_values.PutString("mimetype",_mime);
 //BA.debugLineNum = 323;BA.debugLine="cr.Insert(dataUri, Values)";
_cr.Insert(_datauri,(android.content.ContentValues)(_values.getObject()));
 };
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public String  _setnote(long _id,String _note) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
 //BA.debugLineNum = 251;BA.debugLine="Public Sub SetNote(Id As Long, Note As String)";
 //BA.debugLineNum = 252;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 253;BA.debugLine="v.Initialize";
_v.Initialize();
 //BA.debugLineNum = 254;BA.debugLine="v.PutString(\"data1\", Note)";
_v.PutString("data1",_note);
 //BA.debugLineNum = 255;BA.debugLine="SetData(\"vnd.android.cursor.item/note\", v, Id, Tr";
_setdata("vnd.android.cursor.item/note",_v,_id,__c.True);
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public String  _setstarred(long _id,boolean _starred) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values = null;
 //BA.debugLineNum = 330;BA.debugLine="Public Sub SetStarred (Id As Long, Starred As Bool";
 //BA.debugLineNum = 331;BA.debugLine="Dim values As ContentValues";
_values = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 332;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 333;BA.debugLine="values.PutBoolean(\"starred\", Starred)";
_values.PutBoolean("starred",_starred);
 //BA.debugLineNum = 334;BA.debugLine="cr.Update(contactUri, values, \"_id = ?\", Array As";
_cr.Update((android.net.Uri)(_contacturi.getObject()),(android.content.ContentValues)(_values.getObject()),"_id = ?",new String[]{BA.NumberToString(_id)});
 //BA.debugLineNum = 335;BA.debugLine="End Sub";
return "";
}
public String  _updatenote(String _name,String _note) throws Exception{
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _u = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
long _id = 0L;
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _cv = null;
 //BA.debugLineNum = 431;BA.debugLine="public Sub UpdateNote(Name As String, Note As Stri";
 //BA.debugLineNum = 433;BA.debugLine="Dim u As Uri";
_u = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 434;BA.debugLine="u.Parse(\"content://com.android.contacts/contacts\"";
_u.Parse("content://com.android.contacts/contacts");
 //BA.debugLineNum = 435;BA.debugLine="Dim crsr As Cursor = cr.Query(u, Array As String(";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = _cr.Query(_u,new String[]{"_id"},"display_name = ?",new String[]{_name},"");
 //BA.debugLineNum = 436;BA.debugLine="If crsr.RowCount = 0 Then";
if (_crsr.getRowCount()==0) { 
 //BA.debugLineNum = 437;BA.debugLine="Log(\"No match found: \" & Name)";
__c.LogImpl("43211270","No match found: "+_name,0);
 }else {
 //BA.debugLineNum = 440;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
 //BA.debugLineNum = 441;BA.debugLine="Dim id As Long = crsr.GetLong(\"_id\")";
_id = _crsr.GetLong("_id");
 //BA.debugLineNum = 443;BA.debugLine="Dim cv As ContentValues";
_cv = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
 //BA.debugLineNum = 444;BA.debugLine="cv.Initialize";
_cv.Initialize();
 //BA.debugLineNum = 445;BA.debugLine="cv.PutString(\"data1\", Note)";
_cv.PutString("data1",_note);
 //BA.debugLineNum = 446;BA.debugLine="Dim dataUri As Uri";
_datauri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
 //BA.debugLineNum = 447;BA.debugLine="dataUri.Parse(\"content://com.android.contacts/da";
_datauri.Parse("content://com.android.contacts/data");
 //BA.debugLineNum = 448;BA.debugLine="Log(cr.Update(dataUri, cv, \"mimetype = 'vnd.andr";
__c.LogImpl("43211281",BA.NumberToString(_cr.Update((android.net.Uri)(_datauri.getObject()),(android.content.ContentValues)(_cv.getObject()),"mimetype = 'vnd.android.cursor.item/note' AND contact_id = ?",new String[]{BA.NumberToString(_id)})),0);
 };
 //BA.debugLineNum = 453;BA.debugLine="crsr.Close";
_crsr.Close();
 //BA.debugLineNum = 454;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
