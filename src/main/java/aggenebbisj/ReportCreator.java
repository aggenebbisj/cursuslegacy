package aggenebbisj;

public class ReportCreator {

	public static Report createReport(DataLine[] dataLines) {
		Report report = new Report();
		
		Record currentRecord = null;
		String previousId = null;
		for (DataLine line : dataLines) {
			if (previousId == null || !line.getCustomerId().equals(previousId)) {
				if (previousId != null) {
					finalizeRecord(report, currentRecord);
				}
				currentRecord = new Record();
				currentRecord.setCustomerId(line.getCustomerId());
				currentRecord.setWeek(line.getWeek());
				currentRecord.setCurrency(line.getCurrency());
				currentRecord.setTotalAmount(line.getAmount());
			}
			
			currentRecord.addAmount(line.getAmount());
			
		}
		
		if (currentRecord != null) {
			finalizeRecord(report, currentRecord);
		}
		
		return report;
	}

	private static void finalizeRecord(Report report, Record currentRecord) {
		if (Configuration.getInstance().shouldRound()) {
			currentRecord.setTotalAmount(Math.round(currentRecord.getTotalAmount()));
		}
		report.add(currentRecord);
	}
}
