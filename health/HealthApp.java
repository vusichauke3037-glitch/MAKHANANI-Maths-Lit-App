<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Health Monitor - Vukona Press</title>
<meta name="theme-color" content="#0d6e3f">
<style>
*{box-sizing:border-box;font-family:Segoe UI,Arial} body{margin:0;background:#e8f5e9}
header{background:#0d6e3f;color:#fff;padding:16px;text-align:center;position:sticky;top:0}
.grid{max-width:900px;margin:12px auto;padding:0 12px;display:grid;grid-template-columns:repeat(auto-fit,minmax(280px,1fr));gap:12px}
.card{background:#fff;padding:16px;border-radius:12px;box-shadow:0 2px 8px rgba(0,0,0,.1);border-left:5px solid #0d6e3f}
label{font-size:12px;font-weight:700;display:block;margin-top:8px}
input,select{width:100%;padding:8px;border:1px solid #a5d6a7;border-radius:6px;margin-top:3px}
button{width:100%;margin-top:10px;background:#0d6e3f;color:#fff;border:none;padding:10px;border-radius:8px;font-weight:700;cursor:pointer}
.result{margin-top:10px;background:#f1f8e9;padding:8px;border-radius:6px;font-size:13px;white-space:pre-wrap;font-weight:600;min-height:22px}
.alert{background:#fff3e0;border-left:4px solid #ef6c00;padding:8px;font-size:11px;margin-top:8px}
</style>
</head>
<body>
<header><h1 style="margin:0">HEALTH MONITOR</h1><p style="margin:0;font-size:11px">Vukona Press - Siyabonga Vusi! - Track, Don't Diagnose</p></header>

<div class="grid">

<div class="card"><h3>1. Blood Pressure</h3>
<label>Systolic (top) e.g 120</label><input id="sys" type="number" value="125">
<label>Diastolic (bottom) e.g 80</label><input id="dia" type="number" value="82">
<button onclick="bp()">Check BP Category</button><div id="bpRes" class="result"></div>
<div class="alert">Normal <120/80. High if >=140/90 - see clinic.</div></div>

<div class="card"><h3>2. Blood Sugar (Glucose)</h3>
<label>Reading mmol/L e.g 5.5</label><input id="sugar" type="number" step="0.1" value="6.2">
<select id="sugarType"><option>Fasting</option><option>After meal (2hr)</option></select>
<button onclick="sugar()">Track Sugar</button><div id="sugarRes" class="result"></div></div>

<div class="card"><h3>3. BMI Calculator</h3>
<label>Weight kg</label><input id="w" type="number" value="75">
<label>Height cm</label><input id="h" type="number" value="170">
<button onclick="bmi()">BMI = kg/m²</button><div id="bmiRes" class="result"></div></div>

<div class="card"><h3>4. Heart Rate & Temp</h3>
<label>Heart Rate bpm</label><input id="hr" type="number" value="78">
<label>Temperature °C</label><input id="temp" type="number" step="0.1" value="36.8">
<button onclick="hrtemp()">Check</button><div id="hrRes" class="result"></div></div>

<div class="card"><h3>5. Water & Steps Today</h3>
<label>Glasses of water (0-12)</label><input id="water" type="number" value="4">
<label>Steps today</label><input id="steps" type="number" value="3500">
<button onclick="daily()">Daily Goals</button><div id="dailyRes" class="result"></div></div>

<div class="card"><h3>6. Meds & Emergency</h3>
<label>Chronic Condition</label><select id="cond"><option>Hypertension</option><option>Diabetes</option><option>None</option><option>HIV</option></select>
<label>Next Clinic Date</label><input id="clinicDate" type="date">
<button onclick="meds()">Set Reminder</button><div id="medsRes" class="result"></div>
<p style="font-size:11px">🚑 Ambulance: 10177 | Clinic: 011 123 4567<br>For medical advice, speak to a healthcare professional.</p></div>

</div>

<script>
function bp(){
let s=parseFloat(document.getElementById('sys').value), d=parseFloat(document.getElementById('dia').value);
let cat=s<120&&d<80?'NORMAL':s<130&&d<80?'Elevated':s<140||d<90?'High Stage 1':s<180||d<120?'High Stage 2':'CRISIS - Go to clinic now!';
document.getElementById('bpRes').innerText=`${s}/${d} mmHg = ${cat}\nDate: ${new Date().toLocaleString()}\nTip: Rest 5 min before measuring.`;
}
function sugar(){
let v=parseFloat(document.getElementById('sugar').value), t=document.getElementById('sugarType').value;
let cat=t=='Fasting'? (v<5.6?'Normal fasting':v<7.0?'Prediabetes - see clinic':'High - see clinic') : (v<7.8?'Normal after meal':v<11.1?'Elevated':'High');
document.getElementById('sugarRes').innerText=`Sugar ${v} mmol/L ${t} = ${cat}\nLogged: ${new Date().toLocaleDateString()}`;
}
function bmi(){
let w=parseFloat(document.getElementById('w').value), h=parseFloat(document.getElementById('h').value)/100; let bmi=w/(h*h);
let cat=bmi<18.5?'Underweight':bmi<25?'Healthy':bmi<30?'Overweight':bmi<35?'Obese I':bmi<40?'Obese II':'Obese III';
document.getElementById('bmiRes').innerText=`Weight ${w}kg Height ${(h).toFixed(2)}m\nBMI = ${bmi.toFixed(1)} = ${cat}\nHealthy BMI 18.5-24.9`;
}
function hrtemp(){
let hr=parseFloat(document.getElementById('hr').value), temp=parseFloat(document.getElementById('temp').value);
let hrcat=hr<60?'Low (athlete/bradycardia)':hr<=100?'Normal 60-100':'High - rest & recheck';
let tempcat=temp<36.1?'Low':temp<=37.2?'Normal':temp<=38?'Low fever - monitor':'Fever - see clinic';
document.getElementById('hrRes').innerText=`HR ${hr} bpm = ${hrcat}\nTemp ${temp}°C = ${tempcat}`;
}
function daily(){
let water=parseInt(document.getElementById('water').value), steps=parseInt(document.getElementById('steps').value);
document.getElementById('dailyRes').innerText=`Water ${water}/8 glasses ${(water/8*100).toFixed(0)}% ${water>=6?'Good!':'Drink more'}\nSteps ${steps}/5000 ${(steps/5000*100).toFixed(0)}% ${steps>=5000?'Goal reached!':'Keep walking'}`;
}
function meds(){
let cond=document.getElementById('cond').value, date=document.getElementById('clinicDate').value||'Set date';
document.getElementById('medsRes').innerText=`Condition: ${cond}\nNext clinic: ${date}\nReminder set 1 day before\nTake meds same time daily`;
}
window.onload=()=>{bp();bmi();daily();}
</script>
</body>
</html>
