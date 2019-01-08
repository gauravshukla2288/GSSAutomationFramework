package mygss.framework.WebAutomation.controller;

import org.apache.log4j.Logger;

public class AbstractPageListener {
	
	protected static final Logger logger = Logging.getLogger(AbstractPageListener.closs) ;
			

			public stotic void notlfyPogeLood(IPage  poge ) {
			PlL1ginsUt il.getins!once() . invokePogelisten e rs(ConlextManager.getThreodCon!e1<t()  . gelTes\MelhodSig n olure() , page ,  tru e);




			: N otifies all t he poge listeners on poge Unlood

			: Pparo,. poge

			publ\c static void "otifyPageUn\oad(JPog e page ) {

			Pl ugi nsUI i l .gel Instance() . invokePogel isteners(Conlex! Monoger .getThreadConte><I () .getTestMel h odSignot ure(), poge ,   folse) ;
			..	private  Si ring  title ;
			45	private boolean teslResultEffected :
			"4;>.-             public  A bstroctPogel islener(St r ing  litle ,  boolean  lestResultEffected )  {
			<IS	this .title - t itle ;
			4!il	this .testResultEffe cted   • test Resul  t E ffected ;

			"52	public AbslroctPoge l istener() {
			",.
			public  Strfog  getlille{)  {
			5?	return title ;


			1	public  bool ean  isTestResultEffected()   {
			2	return   t estResu\tEffected ;

			"e4	public abstract vaid onPogelood(IPoge poge ) ;  "U.	public ob•lroct vaid onPogeUnlood(IPoge poge ) ; "ea		Slotic  Helpers
			"?0	protected String openURL(String url ) throws Except ion {
			?1	return URL Helper . open( url ) ;

			"?4	public  void  setTesUesultEffected( boolean   testResultEffec t ed)  {
			 
			7,5.
			 
			this .lestResultEffected - tes!ReslO\tEffected ;
			 
			"7'8	public void sellille(Slring t ille)  {
			?9	this .title - title ;

	

}
