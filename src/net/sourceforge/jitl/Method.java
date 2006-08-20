package net.sourceforge.jitl;

import net.sourceforge.jitl.astro.Utils;

public class Method {
	private double fajrAng; 
	
	private double ishaaAng; 
	
	private double imsaakAng; /* */
	
	private int fajrInv; /* */
	
	private int ishaaInv; /*  */
	
	private int imsaakInv; /*  */
	
	private Rounding round; /*  */
	
	private Mathhab mathhab; /* :
	1: Shaf'i (default)
	2: Hanafi 
	*/
	
	private double nearestLat; /* Latitude Used for the 'Nearest Latitude' extreme methods. The default is 48.5 */
	
	private ExtremeLatitude extremeLatitude;/* Extreme latitude calculation method (see below) */
	
	private int offset; /* */
	
	private double fajrOffset;
	
	private double shurooqOffset;
	
	private double thuhrOffset;
	
	private double assrOffset;
	
	private double maghribOffset;
	
	private double ishaaOffset;
	
	public Method() {
	}
	
	/**
	 * copy constructor
	 * @param orig Method to copy from
	 */
	public Method(Method orig) {
		this.fajrAng = orig.getFajrAng();
		this.ishaaAng = orig.getIshaaAng();
		this.imsaakAng = orig.getImsaakAng();
		this.fajrInv = orig.getFajrInv();
		this.ishaaInv = orig.getIshaaInv();
		this.imsaakInv = orig.getImsaakInv();
		this.round = orig.getRound();
		this.mathhab = orig.getMathhab();
		this.nearestLat = orig.getNearestLat();
		this.extremeLatitude = orig.getExtremeLatitude();
		this.offset = orig.getOffset();
		
		this.fajrOffset = orig.getFajrOffset();
		this.shurooqOffset = orig.getShurooqOffset();
		this.thuhrOffset = orig.getThuhrOffset();
		this.assrOffset = orig.getAssrOffset();
		this.maghribOffset = orig.getMaghribOffset();
		this.ishaaOffset = orig.getIshaaOffset();		
	}
	
	/**
	 * Build a method object containing all the information needed to compute
	 * prayer time.
	 *  
	 * @param fajrAng Fajr angle
	 * @param ishaaAng Ishaa angle 
	 * @param imsaakAng The angle difference between Imsaak and Fajr (default
	 *  is 1.5)
	 * @param fajrInv Fajr Interval is the amount of minutes between Fajr and 
	 *  Shurooq (0 if not used) 
	 * @param ishaaInv Ishaa Interval is the amount if minutes between Ishaa and
	 *  Maghrib (0 if not used)
	 * @param imsaakInv Imsaak Interval is the amount of minutes between Imsaak
	 *  and Fajr. The default is 10 minutes before Fajr if Fajr Interval is set
	 * @param round Method used for rounding seconds
	 * @param mathhab Assr prayer shadow ratio
	 * @param nearestLat
	 * @param extreme
	 * @param offset Enable Offsets switch (set this to 1 to activate). This
	 *  option allows you to add or subtract any amount of minutes to the daily
	 *  computed prayer times based on values (in minutes) for each prayer in
	 *  the next xxxOffset parameters 	
	 *  For Example: If you want to add 30 seconds to Maghrib and subtract 2
	 *  minutes from Ishaa: 
	 *   offset = 1 
	 *   maghribOffset = 0.5 
	 *   ishaaOffset = -2	 
	 * @param fajrOffset fajr offset
	 * @param shurooqOffset shurooq offset
	 * @param thuhrOffset thuhr offset
	 * @param assrOffset assr offset
	 * @param maghribOffset maghrib offset
	 * @param ishaaOffset ishaa offset
	 */
	public Method(double fajrAng, double ishaaAng, double imsaakAng,
			int fajrInv, int ishaaInv, int imsaakInv, Rounding round, Mathhab mathhab,
			double nearestLat, ExtremeLatitude extreme, int offset, double fajrOffset,
			double shurooqOffset, double thuhrOffset, double assrOffset,
			double maghribOffset, double ishaaOffset) {
		this.fajrAng = fajrAng;
		this.ishaaAng = ishaaAng;
		this.imsaakAng = imsaakAng;
		this.fajrInv = fajrInv;
		this.ishaaInv = ishaaInv;
		this.imsaakInv = imsaakInv;
		this.round = round;
		this.mathhab = mathhab;
		this.nearestLat = nearestLat;
		this.extremeLatitude = extreme;
		this.offset = offset;
		
		this.fajrOffset = fajrOffset;
		this.shurooqOffset = shurooqOffset;
		this.thuhrOffset = thuhrOffset;
		this.assrOffset = assrOffset;
		this.maghribOffset = maghribOffset;
		this.ishaaOffset = ishaaOffset;
		
	}
	
	public Method copy() {
		return new Method(fajrAng, ishaaAng, imsaakAng, fajrInv, ishaaInv,
				imsaakInv, round, mathhab, nearestLat, extremeLatitude, offset,
				fajrOffset, shurooqOffset, thuhrOffset, assrOffset,
				maghribOffset, ishaaOffset);
	}
	
	public ExtremeLatitude getExtremeLatitude() {
		return extremeLatitude;
	}
	
	public void setExtremeLatitude(ExtremeLatitude extreme) {
		this.extremeLatitude = extreme;
	}
	
	public double getFajrAng() {
		return fajrAng;
	}
	
	public void setFajrAng(double fajrAng) {
		this.fajrAng = fajrAng;
	}
	
	public int getFajrInv() {
		return fajrInv;
	}
	
	public void setFajrInv(int fajrInv) {
		this.fajrInv = fajrInv;
	}
	
	public double getImsaakAng() {
		return imsaakAng;
	}
	
	public void setImsaakAng(double imsaakAng) {
		this.imsaakAng = imsaakAng;
	}
	
	public int getImsaakInv() {
		return imsaakInv;
	}
	
	public void setImsaakInv(int imsaakInv) {
		this.imsaakInv = imsaakInv;
	}
	
	public double getIshaaAng() {
		return ishaaAng;
	}
	
	public void setIshaaAng(double ishaaAng) {
		this.ishaaAng = ishaaAng;
	}
	
	public int getIshaaInv() {
		return ishaaInv;
	}
	
	public void setIshaaInv(int ishaaInv) {
		this.ishaaInv = ishaaInv;
	}
	
	public Mathhab getMathhab() {
		return mathhab;
	}
	
	public void setMathhab(Mathhab mathhab) {
		this.mathhab = mathhab;
	}
	
	public double getNearestLat() {
		return nearestLat;
	}
	
	public void setNearestLat(double nearestLat) {
		this.nearestLat = nearestLat;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public Rounding getRound() {
		return round;
	}
	
	public void setRound(Rounding round) {
		this.round = round;
	}
	
	/*
	 fajrAng, ishaaAng, imsaakAng, fajrInv = 0, ishaaInv = 0, imsaakInv = 0, round = 2, mathhab = 1,
	 nearestLat =  Utils.DEF_NEAREST_LATITUDE , extreme = 5, offset = 0, offList = null
	 */
	
	public static final Method NONE = new Method(0.0, 0.0, 0, 0, 0, 0, Rounding.SPECIAL, Mathhab.SHAAFI,
			Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method EGYPT_SURVEY = new Method(20, 18, 0, 0, 0, 0, Rounding.SPECIAL,
			Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method KARACHI_SHAF = new Method(18, 18, 0, 0, 0, 0, Rounding.SPECIAL,
			Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method KARACHI_HANAF = new Method(18, 18, 0, 0, 0, 0,
			Rounding.SPECIAL, Mathhab.HANAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method NORTH_AMERICA = new Method(15, 15, 0, 0, 0, 0,
			Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method MUSLIM_LEAGUE = new Method(18, 17, 0, 0, 0, 0,
			Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method UMM_ALQURRA = new Method(19, 0, 0, 0, 90, 0, Rounding.SPECIAL,
			Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public static final Method FIXED_ISHAA = new Method(19.5, 0, 0, 0, 90, 0,
			Rounding.SPECIAL, Mathhab.SHAAFI, Utils.DEF_NEAREST_LATITUDE, ExtremeLatitude.GOOD_INVALID, 0, 0, 0, 0, 0, 0, 0);
	
	public double getAssrOffset() {
		return assrOffset;
	}
	
	public void setAssrOffset(double assrOffset) {
		this.assrOffset = assrOffset;
	}
	
	public double getFajrOffset() {
		return fajrOffset;
	}
	
	public void setFajrOffset(double fajrOffset) {
		this.fajrOffset = fajrOffset;
	}
	
	public double getIshaaOffset() {
		return ishaaOffset;
	}
	
	public void setIshaaOffset(double ishaaOffset) {
		this.ishaaOffset = ishaaOffset;
	}
	
	public double getMaghribOffset() {
		return maghribOffset;
	}
	
	public void setMaghribOffset(double maghribOffset) {
		this.maghribOffset = maghribOffset;
	}
	
	public double getShurooqOffset() {
		return shurooqOffset;
	}
	
	public void setShurooqOffset(double shurooqOffset) {
		this.shurooqOffset = shurooqOffset;
	}
	
	public double getThuhrOffset() {
		return thuhrOffset;
	}
	
	public void setThuhrOffset(double thuhrOffset) {
		this.thuhrOffset = thuhrOffset;
	}
	
	public double getOffset(PrayerTime prayer) {
		if (prayer == PrayerTime.FAJR)
			return getFajrOffset();
		if (prayer == PrayerTime.SHUROOQ)
			return getShurooqOffset();
		if (prayer == PrayerTime.THUHR)
			return getThuhrOffset();
		if (prayer == PrayerTime.ASSR)
			return getAssrOffset();
		if (prayer == PrayerTime.MAGHRIB)
			return getMaghribOffset();
		if (prayer == PrayerTime.ISHAA)
			return getIshaaOffset();
		return 0;
	}
	
}
