
class Excel {

    int[][] sheet;
    int height;
    int width;

    public Excel(int height, char width) {

        this.height = height;
        this.width = width - 'A' + 1;

        sheet = new int[height][this.width];
    }

    public void set(int row, char column, int val) {

        int col = column - 'A';

        sheet[row - 1][col] = val;
    }

    public int get(int row, char column) {

        int col = column - 'A';

        return sheet[row - 1][col];
    }

    public int sum(int row, char column, String[] numbers) {

        int total = 0;

        for (String s : numbers) {

            if (s.contains(":")) {

                String[] range = s.split(":");

                String start = range[0];
                String end = range[1];

                int startRow = Integer.parseInt(start.substring(1));
                int endRow = Integer.parseInt(end.substring(1));

                char startCol = start.charAt(0);
                char endCol = end.charAt(0);

                for (int r = startRow; r <= endRow; r++) {

                    for (char c = startCol; c <= endCol; c++) {

                        total += get(r, c);
                    }
                }

            } else {

                int r = Integer.parseInt(s.substring(1));
                char c = s.charAt(0);

                total += get(r, c);
            }
        }

        sheet[row - 1][column - 'A'] = total;

        return total;
    }
}
