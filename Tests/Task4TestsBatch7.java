package csen1002.tests.task4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task4.CfgEpsUnitElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task4TestsBatch7 {

	@Test
	public void testCfgEpsilonRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;U;X;B;F;N;Y#h;k;q;s#S/Ss,XkY,s;U/F,S,k,kBSBS,sUXU;X/B,X,YX,Yq,e,qFNqS;B/F,FF,SFUk,YY,kF;F/B,N,NBXhN,XS,YkXq;N/e,hUsNB,kFk,qYsX;Y/hSX,sB");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;U;X;B;F;N;Y#h;k;q;s#S/Ss,XkY,kY,s;U/F,S,k,kBSBS,kBSS,kSBS,kSS,s,sU,sUU,sUX,sUXU,sX,sXU;X/B,X,Y,YX,Yq,qFNqS,qFqS,qNqS,qqS;B/F,FF,SFUk,SFk,SUk,Sk,YY,k,kF;F/B,BXh,BXhN,Bh,BhN,N,NBXh,NBXhN,NBh,NBhN,NXh,NXhN,Nh,NhN,S,XS,Xh,XhN,YkXq,Ykq,h,hN;N/hUs,hUsB,hUsN,hUsNB,hs,hsB,hsN,hsNB,kFk,kk,qYs,qYsX;Y/hS,hSX,s,sB", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;T;Z;C;P;U#f;l;p#S/US,UlTf;T/S,U,USU,e,fCPfU,fTZfZ;Z/C,PlSf,S;C/S,SZfSP,TT,UPSU,lZ;P/P,UCZp,Zp,e,lST,pCUSf;U/Sp,pS");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;T;Z;C;P;U#f;l;p#S/US,UlTf,Ulf;T/S,U,USU,fCPfU,fCfU,fPfU,fTZf,fTZfZ,fTf,fTfZ,fZf,fZfZ,ff,ffU,ffZ;Z/C,PlSf,S,lSf;C/S,SZfS,SZfSP,SfS,SfSP,T,TT,UPSU,USU,l,lZ;P/P,UCZp,UCp,UZp,Up,Zp,lS,lST,p,pCUSf,pUSf;U/Sp,pS", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;Z;U;J;O;F;M#b;g;k#S/SS,bSSM,kU;Z/FMMOk,SZOU,e;U/F,FJS,Z,k,kFZ,kUJgM;J/J,U,bJFOg,bJg,kUS;O/kJkM,kZMU;F/F,U,ZkJJU,bFSgZ,e,kZb;M/Jb,O,SFgZ");
		cfgEpsUnitElim.eliminateEpsilonRules();
		assertEquals("S;Z;U;J;O;F;M#b;g;k#S/SS,bSSM,k,kU;Z/FMMOk,MMOk,SO,SOU,SZO,SZOU;U/F,FJS,FS,JS,S,Z,k,kF,kFZ,kJgM,kUJgM,kUgM,kZ,kgM;J/J,U,bFOg,bJFOg,bJOg,bJg,bOg,bg,kS,kUS;O/kJkM,kM,kMU,kZM,kZMU,kkM;F/F,U,Zk,ZkJ,ZkJJ,ZkJJU,ZkJU,ZkU,bFSg,bFSgZ,bSg,bSgZ,k,kJ,kJJ,kJJU,kJU,kU,kZb,kb;M/Jb,O,SFg,SFgZ,Sg,SgZ,b", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;J;B;H;Y;K;E#r;x;z#S/KYx,rB,rSxJH;J/B,H,xS,zJK;B/KJHS,xEH;H/B,HzJH,xBS;Y/B,HBrH,J,K;K/HHzSr,JHrHr,K,KxEx,KzYJS;E/BzHzY,HJxYx,JH,KErSK");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;J;B;H;Y;K;E#r;x;z#S/KYx,rB,rSxJH;J/HzJH,KJHS,xBS,xEH,xS,zJK;B/KJHS,xEH;H/HzJH,KJHS,xBS,xEH;Y/HBrH,HHzSr,HzJH,JHrHr,KJHS,KxEx,KzYJS,xBS,xEH,xS,zJK;K/HHzSr,JHrHr,KxEx,KzYJS;E/BzHzY,HJxYx,JH,KErSK", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;F;W;X;A;H#f;k;z#S/AAAXk,S,W,kFFS;F/AfF,X;W/AFAk,F,k;X/HXS,Sf,zX;A/A,SAkF,XXWf,fFk,zFkWA;H/AAFz,S,fXXHA");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;F;W;X;A;H#f;k;z#S/AAAXk,AFAk,AfF,HXS,Sf,k,kFFS,zX;F/AfF,HXS,Sf,zX;W/AFAk,AfF,HXS,Sf,k,zX;X/HXS,Sf,zX;A/SAkF,XXWf,fFk,zFkWA;H/AAAXk,AAFz,AFAk,AfF,HXS,Sf,fXXHA,k,kFFS,zX", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgUnitRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;B;R;V;G#b;d;g;x;y#S/R,S,xSx;B/GBS,S,SVgGV,VVBG,x;R/xGSBV,xGdVb,xS,yVVd;V/B,Bg,S,V,VB,VVdR;G/R,RBVS,yG");
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;B;R;V;G#b;d;g;x;y#S/xGSBV,xGdVb,xS,xSx,yVVd;B/GBS,SVgGV,VVBG,x,xGSBV,xGdVb,xS,xSx,yVVd;R/xGSBV,xGdVb,xS,yVVd;V/Bg,GBS,SVgGV,VB,VVBG,VVdR,x,xGSBV,xGdVb,xS,xSx,yVVd;G/RBVS,xGSBV,xGdVb,xS,yG,yVVd", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination1() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;L;K;B;C;E;U#g;i;s#S/CBi,L,iB;L/S,gLC,i;K/EiKEi,KSgEK,SBg,g;B/E,EgE,K,e,g,gEgK,sKUE;C/BC,LB,e,i,sCiB;E/Es,KL;U/BKg,LsBS");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;L;K;B;C;E;U#g;i;s#S/Bi,CBi,Ci,gL,gLC,i,iB;L/Bi,CBi,Ci,gL,gLC,i,iB;K/EiKEi,KSgEK,SBg,Sg,g;B/EgE,EiKEi,Es,KL,KSgEK,SBg,Sg,g,gEgK,sKUE;C/BC,Bi,CBi,Ci,EgE,EiKEi,Es,KL,KSgEK,LB,SBg,Sg,g,gEgK,gL,gLC,i,iB,sCi,sCiB,sKUE,si,siB;E/Es,KL;U/BKg,Kg,LsBS,LsS", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination2() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;C;G;V;F;J;W#b;g;z#S/C,GFb,gF,zSJ;C/GbWWC,V,gFC;G/CSgG,FgJVg,bWFW,e;V/SGzWJ,V,VSg;F/W,bWb,e,z;J/CC,GbGg,J,VJgVz,e;W/GJV,z");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;C;G;V;F;J;W#b;g;z#S/Fb,GFb,Gb,GbWWC,SGzW,SGzWJ,SzW,SzWJ,VSg,b,bWWC,g,gC,gF,gFC,zS,zSJ;C/GbWWC,SGzW,SGzWJ,SzW,SzWJ,VSg,bWWC,gC,gFC;G/CSg,CSgG,FgJVg,FgVg,bWFW,bWW,gJVg,gVg;V/SGzW,SGzWJ,SzW,SzWJ,VSg;F/GJV,GV,JV,SGzW,SGzWJ,SzW,SzWJ,VSg,bWb,z;J/CC,GbGg,Gbg,VJgVz,VgVz,bGg,bg;W/GJV,GV,JV,SGzW,SGzWJ,SzW,SzWJ,VSg,z", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination3() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;I;F;C;O;W#d;g;p;r#S/CgFr,S,SWSpC,rCW;I/S,pCp,rCC;F/CFdW,CgSr,O,S,e;C/e,gCO,gWS;O/F,Sp,SrWr,WOg,dI;W/FpOIF,IOC,OpW");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;I;F;C;O;W#d;g;p;r#S/CgFr,Cgr,SWSp,SWSpC,gFr,gr,rCW,rW;I/CgFr,Cgr,SWSp,SWSpC,gFr,gr,pCp,pp,r,rC,rCC,rCW,rW;F/CFdW,CdW,CgFr,CgSr,Cgr,FdW,SWSp,SWSpC,Sp,SrWr,WOg,Wg,dI,dW,gFr,gSr,gr,rCW,rW;C/g,gC,gCO,gO,gWS;O/CFdW,CdW,CgFr,CgSr,Cgr,FdW,SWSp,SWSpC,Sp,SrWr,WOg,Wg,dI,dW,gFr,gSr,gr,rCW,rW;W/CgFr,Cgr,FpI,FpIF,FpOI,FpOIF,IC,IO,IOC,OpW,SWSp,SWSpC,gFr,gr,pCp,pI,pIF,pOI,pOIF,pW,pp,r,rC,rCC,rCW,rW", cfgEpsUnitElim.toString());
	}

	@Test
	public void testCfgEpsilonUnitRuleElimination4() {
		CfgEpsUnitElim cfgEpsUnitElim= new CfgEpsUnitElim("S;E;Q;Z;W#a;j;l;q;z#S/SEqE,jEZ,l;E/Q,S,WQQZ,Z,e,lSQl;Q/QQSE,Z,e;Z/WlSa,lS;W/QZz,Wz,ZSa,zSZWl");
		cfgEpsUnitElim.eliminateEpsilonRules();
		cfgEpsUnitElim.eliminateUnitRules();
		assertEquals("S;E;Q;Z;W#a;j;l;q;z#S/SEq,SEqE,Sq,SqE,jEZ,jZ,l;E/QQS,QQSE,QS,QSE,SE,SEq,SEqE,Sq,SqE,WQQZ,WQZ,WZ,WlSa,jEZ,jZ,l,lS,lSQl,lSl;Q/QQS,QQSE,QS,QSE,SE,SEq,SEqE,Sq,SqE,WlSa,jEZ,jZ,l,lS;Z/WlSa,lS;W/QZz,Wz,ZSa,Zz,zSZWl", cfgEpsUnitElim.toString());
	}

}