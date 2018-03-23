package com.orange.dictacloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    String aboutHtml = "<html xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
            "xmlns:w=\"urn:schemas-microsoft-com:office:word\"\n" +
            "xmlns:m=\"http://schemas.microsoft.com/office/2004/12/omml\"\n" +
            "xmlns=\"http://www.w3.org/TR/REC-html40\">\n" +
            "\n" +
            "<head>\n" +
            "<meta name=Titre content=\"\">\n" +
            "<meta name=\"Mots clŽs\" content=\"\">\n" +
            "<meta http-equiv=Content-Type content=\"text/html; charset=macintosh\">\n" +
            "<meta name=ProgId content=Word.Document>\n" +
            "<meta name=Generator content=\"Microsoft Word 15\">\n" +
            "<meta name=Originator content=\"Microsoft Word 15\">\n" +
            "<link rel=File-List href=\"DICTACLOUD.fld/filelist.xml\">\n" +
            "<!--[if gte mso 9]><xml>\n" +
            " <o:DocumentProperties>\n" +
            "  <o:Author>Utilisateur de Microsoft Office</o:Author>\n" +
            "  <o:LastAuthor>Utilisateur de Microsoft Office</o:LastAuthor>\n" +
            "  <o:Revision>2</o:Revision>\n" +
            "  <o:TotalTime>6</o:TotalTime>\n" +
            "  <o:Created>2018-03-19T19:28:00Z</o:Created>\n" +
            "  <o:LastSaved>2018-03-19T19:28:00Z</o:LastSaved>\n" +
            "  <o:Pages>1</o:Pages>\n" +
            "  <o:Words>239</o:Words>\n" +
            "  <o:Characters>1318</o:Characters>\n" +
            "  <o:Lines>10</o:Lines>\n" +
            "  <o:Paragraphs>3</o:Paragraphs>\n" +
            "  <o:CharactersWithSpaces>1554</o:CharactersWithSpaces>\n" +
            "  <o:Version>15.0</o:Version>\n" +
            " </o:DocumentProperties>\n" +
            " <o:OfficeDocumentSettings>\n" +
            "  <o:AllowPNG/>\n" +
            "  <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            " </o:OfficeDocumentSettings>\n" +
            "</xml><![endif]-->\n" +
            "<link rel=themeData href=\"DICTACLOUD.fld/themedata.thmx\">\n" +
            "<!--[if gte mso 9]><xml>\n" +
            " <w:WordDocument>\n" +
            "  <w:View>Normal</w:View>\n" +
            "  <w:Zoom>230</w:Zoom>\n" +
            "  <w:SpellingState>Clean</w:SpellingState>\n" +
            "  <w:GrammarState>Clean</w:GrammarState>\n" +
            "  <w:TrackMoves>false</w:TrackMoves>\n" +
            "  <w:TrackFormatting/>\n" +
            "  <w:HyphenationZone>21</w:HyphenationZone>\n" +
            "  <w:PunctuationKerning/>\n" +
            "  <w:ValidateAgainstSchemas/>\n" +
            "  <w:SaveIfXMLInvalid>false</w:SaveIfXMLInvalid>\n" +
            "  <w:IgnoreMixedContent>false</w:IgnoreMixedContent>\n" +
            "  <w:AlwaysShowPlaceholderText>false</w:AlwaysShowPlaceholderText>\n" +
            "  <w:DoNotPromoteQF/>\n" +
            "  <w:LidThemeOther>FR</w:LidThemeOther>\n" +
            "  <w:LidThemeAsian>X-NONE</w:LidThemeAsian>\n" +
            "  <w:LidThemeComplexScript>X-NONE</w:LidThemeComplexScript>\n" +
            "  <w:Compatibility>\n" +
            "   <w:BreakWrappedTables/>\n" +
            "   <w:SnapToGridInCell/>\n" +
            "   <w:WrapTextWithPunct/>\n" +
            "   <w:UseAsianBreakRules/>\n" +
            "   <w:DontGrowAutofit/>\n" +
            "   <w:SplitPgBreakAndParaMark/>\n" +
            "   <w:EnableOpenTypeKerning/>\n" +
            "   <w:DontFlipMirrorIndents/>\n" +
            "   <w:OverrideTableStyleHps/>\n" +
            "  </w:Compatibility>\n" +
            "  <m:mathPr>\n" +
            "   <m:mathFont m:val=\"Cambria Math\"/>\n" +
            "   <m:brkBin m:val=\"before\"/>\n" +
            "   <m:brkBinSub m:val=\"&#45;-\"/>\n" +
            "   <m:smallFrac m:val=\"off\"/>\n" +
            "   <m:dispDef/>\n" +
            "   <m:lMargin m:val=\"0\"/>\n" +
            "   <m:rMargin m:val=\"0\"/>\n" +
            "   <m:defJc m:val=\"centerGroup\"/>\n" +
            "   <m:wrapIndent m:val=\"1440\"/>\n" +
            "   <m:intLim m:val=\"subSup\"/>\n" +
            "   <m:naryLim m:val=\"undOvr\"/>\n" +
            "  </m:mathPr></w:WordDocument>\n" +
            "</xml><![endif]--><!--[if gte mso 9]><xml>\n" +
            " <w:LatentStyles DefLockedState=\"false\" DefUnhideWhenUsed=\"false\"\n" +
            "  DefSemiHidden=\"false\" DefQFormat=\"false\" DefPriority=\"99\"\n" +
            "  LatentStyleCount=\"382\">\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"0\" QFormat=\"true\" Name=\"Normal\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" QFormat=\"true\" Name=\"heading 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 7\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 8\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"9\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"heading 9\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 7\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 8\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index 9\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 7\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 8\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"toc 9\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Normal Indent\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"footnote text\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"annotation text\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"header\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"footer\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"index heading\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"35\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"caption\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"table of figures\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"envelope address\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"envelope return\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"footnote reference\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"annotation reference\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"line number\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"page number\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"endnote reference\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"endnote text\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"table of authorities\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"macro\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"toa heading\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Bullet\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Number\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Bullet 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Bullet 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Bullet 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Bullet 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Number 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Number 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Number 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Number 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"10\" QFormat=\"true\" Name=\"Title\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Closing\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Signature\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"1\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"Default Paragraph Font\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text Indent\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Continue\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Continue 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Continue 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Continue 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"List Continue 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Message Header\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"11\" QFormat=\"true\" Name=\"Subtitle\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Salutation\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Date\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text First Indent\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text First Indent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Heading\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text Indent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Body Text Indent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Block Text\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Hyperlink\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"FollowedHyperlink\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"22\" QFormat=\"true\" Name=\"Strong\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"20\" QFormat=\"true\" Name=\"Emphasis\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Document Map\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Plain Text\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"E-mail Signature\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Top of Form\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Bottom of Form\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Normal (Web)\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Acronym\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Address\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Cite\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Code\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Definition\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Keyboard\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Preformatted\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Sample\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Typewriter\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"HTML Variable\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Normal Table\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"annotation subject\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"No List\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Outline List 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Outline List 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Outline List 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Simple 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Simple 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Simple 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Classic 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Classic 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Classic 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Classic 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Colorful 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Colorful 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Colorful 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Columns 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Columns 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Columns 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Columns 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Columns 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 7\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Grid 8\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 7\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table List 8\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table 3D effects 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table 3D effects 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table 3D effects 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Contemporary\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Elegant\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Professional\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Subtle 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Subtle 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Web 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Web 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Web 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Balloon Text\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" Name=\"Table Grid\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Table Theme\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 7\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 8\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Note Level 9\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" Name=\"Placeholder Text\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"1\" QFormat=\"true\" Name=\"No Spacing\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" Name=\"Revision\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"34\" QFormat=\"true\"\n" +
            "   Name=\"List Paragraph\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"29\" QFormat=\"true\" Name=\"Quote\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"30\" QFormat=\"true\"\n" +
            "   Name=\"Intense Quote\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"60\" Name=\"Light Shading Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"61\" Name=\"Light List Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"62\" Name=\"Light Grid Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"63\" Name=\"Medium Shading 1 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"64\" Name=\"Medium Shading 2 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"65\" Name=\"Medium List 1 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"66\" Name=\"Medium List 2 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"67\" Name=\"Medium Grid 1 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"68\" Name=\"Medium Grid 2 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"69\" Name=\"Medium Grid 3 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"70\" Name=\"Dark List Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"71\" Name=\"Colorful Shading Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"72\" Name=\"Colorful List Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"73\" Name=\"Colorful Grid Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"19\" QFormat=\"true\"\n" +
            "   Name=\"Subtle Emphasis\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"21\" QFormat=\"true\"\n" +
            "   Name=\"Intense Emphasis\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"31\" QFormat=\"true\"\n" +
            "   Name=\"Subtle Reference\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"32\" QFormat=\"true\"\n" +
            "   Name=\"Intense Reference\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"33\" QFormat=\"true\" Name=\"Book Title\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"37\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" Name=\"Bibliography\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"39\" SemiHidden=\"true\"\n" +
            "   UnhideWhenUsed=\"true\" QFormat=\"true\" Name=\"TOC Heading\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"41\" Name=\"Plain Table 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"42\" Name=\"Plain Table 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"43\" Name=\"Plain Table 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"44\" Name=\"Plain Table 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"45\" Name=\"Plain Table 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"40\" Name=\"Grid Table Light\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\" Name=\"Grid Table 1 Light\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\" Name=\"Grid Table 6 Colorful\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\" Name=\"Grid Table 7 Colorful\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"Grid Table 1 Light Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"Grid Table 6 Colorful Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"Grid Table 7 Colorful Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"Grid Table 1 Light Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"Grid Table 6 Colorful Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"Grid Table 7 Colorful Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"Grid Table 1 Light Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"Grid Table 6 Colorful Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"Grid Table 7 Colorful Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"Grid Table 1 Light Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"Grid Table 6 Colorful Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"Grid Table 7 Colorful Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"Grid Table 1 Light Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"Grid Table 6 Colorful Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"Grid Table 7 Colorful Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"Grid Table 1 Light Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"Grid Table 2 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"Grid Table 3 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"Grid Table 4 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"Grid Table 5 Dark Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"Grid Table 6 Colorful Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"Grid Table 7 Colorful Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\" Name=\"List Table 1 Light\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\" Name=\"List Table 6 Colorful\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\" Name=\"List Table 7 Colorful\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"List Table 1 Light Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4 Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"List Table 6 Colorful Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"List Table 7 Colorful Accent 1\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"List Table 1 Light Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4 Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"List Table 6 Colorful Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"List Table 7 Colorful Accent 2\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"List Table 1 Light Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4 Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"List Table 6 Colorful Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"List Table 7 Colorful Accent 3\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"List Table 1 Light Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4 Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"List Table 6 Colorful Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"List Table 7 Colorful Accent 4\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"List Table 1 Light Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4 Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"List Table 6 Colorful Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"List Table 7 Colorful Accent 5\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"46\"\n" +
            "   Name=\"List Table 1 Light Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"47\" Name=\"List Table 2 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"48\" Name=\"List Table 3 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"49\" Name=\"List Table 4 Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"50\" Name=\"List Table 5 Dark Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"51\"\n" +
            "   Name=\"List Table 6 Colorful Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" Priority=\"52\"\n" +
            "   Name=\"List Table 7 Colorful Accent 6\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Mention\"/>\n" +
            "  <w:LsdException Locked=\"false\" SemiHidden=\"true\" UnhideWhenUsed=\"true\"\n" +
            "   Name=\"Smart Hyperlink\"/>\n" +
            " </w:LatentStyles>\n" +
            "</xml><![endif]-->\n" +
            "<style>\n" +
            "<!--\n" +
            " /* Font Definitions */\n" +
            "@font-face\n" +
            "\t{font-family:\"Courier New\";\n" +
            "\tpanose-1:2 7 3 9 2 2 5 2 4 4;\n" +
            "\tmso-font-charset:0;\n" +
            "\tmso-generic-font-family:auto;\n" +
            "\tmso-font-pitch:variable;\n" +
            "\tmso-font-signature:-536859905 -1073711037 9 0 511 0;}\n" +
            "@font-face\n" +
            "\t{font-family:Wingdings;\n" +
            "\tpanose-1:5 0 0 0 0 0 0 0 0 0;\n" +
            "\tmso-font-charset:2;\n" +
            "\tmso-generic-font-family:auto;\n" +
            "\tmso-font-pitch:variable;\n" +
            "\tmso-font-signature:0 268435456 0 0 -2147483648 0;}\n" +
            "@font-face\n" +
            "\t{font-family:\"Cambria Math\";\n" +
            "\tpanose-1:2 4 5 3 5 4 6 3 2 4;\n" +
            "\tmso-font-charset:1;\n" +
            "\tmso-generic-font-family:roman;\n" +
            "\tmso-font-format:other;\n" +
            "\tmso-font-pitch:variable;\n" +
            "\tmso-font-signature:0 0 0 0 0 0;}\n" +
            "@font-face\n" +
            "\t{font-family:Calibri;\n" +
            "\tpanose-1:2 15 5 2 2 2 4 3 2 4;\n" +
            "\tmso-font-charset:0;\n" +
            "\tmso-generic-font-family:auto;\n" +
            "\tmso-font-pitch:variable;\n" +
            "\tmso-font-signature:-536870145 1073786111 1 0 415 0;}\n" +
            " /* Style Definitions */\n" +
            "p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
            "\t{mso-style-unhide:no;\n" +
            "\tmso-style-qformat:yes;\n" +
            "\tmso-style-parent:\"\";\n" +
            "\tmargin:0cm;\n" +
            "\tmargin-bottom:.0001pt;\n" +
            "\tmso-pagination:widow-orphan;\n" +
            "\tfont-size:12.0pt;\n" +
            "\tfont-family:Calibri;\n" +
            "\tmso-ascii-font-family:Calibri;\n" +
            "\tmso-ascii-theme-font:minor-latin;\n" +
            "\tmso-fareast-font-family:Calibri;\n" +
            "\tmso-fareast-theme-font:minor-latin;\n" +
            "\tmso-hansi-font-family:Calibri;\n" +
            "\tmso-hansi-theme-font:minor-latin;\n" +
            "\tmso-bidi-font-family:\"Times New Roman\";\n" +
            "\tmso-bidi-theme-font:minor-bidi;\n" +
            "\tmso-fareast-language:EN-US;}\n" +
            "p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph\n" +
            "\t{mso-style-priority:34;\n" +
            "\tmso-style-unhide:no;\n" +
            "\tmso-style-qformat:yes;\n" +
            "\tmso-margin-top-alt:auto;\n" +
            "\tmargin-right:0cm;\n" +
            "\tmso-margin-bottom-alt:auto;\n" +
            "\tmargin-left:0cm;\n" +
            "\tmso-pagination:widow-orphan;\n" +
            "\tfont-size:12.0pt;\n" +
            "\tfont-family:\"Times New Roman\";\n" +
            "\tmso-fareast-font-family:Calibri;\n" +
            "\tmso-fareast-theme-font:minor-latin;}\n" +
            "span.apple-converted-space\n" +
            "\t{mso-style-name:apple-converted-space;\n" +
            "\tmso-style-unhide:no;}\n" +
            "span.GramE\n" +
            "\t{mso-style-name:\"\";\n" +
            "\tmso-gram-e:yes;}\n" +
            ".MsoChpDefault\n" +
            "\t{mso-style-type:export-only;\n" +
            "\tmso-default-props:yes;\n" +
            "\tfont-family:Calibri;\n" +
            "\tmso-ascii-font-family:Calibri;\n" +
            "\tmso-ascii-theme-font:minor-latin;\n" +
            "\tmso-fareast-font-family:Calibri;\n" +
            "\tmso-fareast-theme-font:minor-latin;\n" +
            "\tmso-hansi-font-family:Calibri;\n" +
            "\tmso-hansi-theme-font:minor-latin;\n" +
            "\tmso-bidi-font-family:\"Times New Roman\";\n" +
            "\tmso-bidi-theme-font:minor-bidi;\n" +
            "\tmso-fareast-language:EN-US;}\n" +
            "@page WordSection1\n" +
            "\t{size:595.0pt 842.0pt;\n" +
            "\tmargin:70.85pt 70.85pt 70.85pt 70.85pt;\n" +
            "\tmso-header-margin:35.4pt;\n" +
            "\tmso-footer-margin:35.4pt;\n" +
            "\tmso-paper-source:0;}\n" +
            "div.WordSection1\n" +
            "\t{page:WordSection1;}\n" +
            "-->\n" +
            "</style>\n" +
            "<!--[if gte mso 10]>\n" +
            "<style>\n" +
            " /* Style Definitions */\n" +
            "table.MsoNormalTable\n" +
            "\t{mso-style-name:\"Tableau Normal\";\n" +
            "\tmso-tstyle-rowband-size:0;\n" +
            "\tmso-tstyle-colband-size:0;\n" +
            "\tmso-style-noshow:yes;\n" +
            "\tmso-style-priority:99;\n" +
            "\tmso-style-parent:\"\";\n" +
            "\tmso-padding-alt:0cm 5.4pt 0cm 5.4pt;\n" +
            "\tmso-para-margin:0cm;\n" +
            "\tmso-para-margin-bottom:.0001pt;\n" +
            "\tmso-pagination:widow-orphan;\n" +
            "\tfont-size:12.0pt;\n" +
            "\tfont-family:Calibri;\n" +
            "\tmso-ascii-font-family:Calibri;\n" +
            "\tmso-ascii-theme-font:minor-latin;\n" +
            "\tmso-hansi-font-family:Calibri;\n" +
            "\tmso-hansi-theme-font:minor-latin;\n" +
            "\tmso-fareast-language:EN-US;}\n" +
            "</style>\n" +
            "<![endif]-->\n" +
            "</head>\n" +
            "\n" +
            "<body bgcolor=white lang=FR style='tab-interval:35.4pt'>\n" +
            "\n" +
            "<div class=WordSection1>\n" +
            "\n" +
            "<p class=MsoNormal align=center style='text-align:center'><span\n" +
            "style='font-size:20.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>DICTACLOUD<o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal align=center style='text-align:center'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Copyright (B. Froger 2018)<o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal align=center style='text-align:center'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Version 1.0.0<o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal><span style='font-size:11.0pt;mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal><span style='font-size:11.0pt;mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>Mode dÕemploi&nbsp;:</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>-</span><span style='font-size:7.0pt;font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>1\u008Fre Žtape&nbsp;: sÕinscrire&nbsp;ou sÕenregistrer :</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Aller dans le menu (3 points en haut ˆ droite)</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>SŽlectionner ÔloginÕ</span><span style='mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Pour sÕinscrire&nbsp;(premi\u008Fre fois) :</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>Renseigner</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'> les 3 champs (Pseudo, Email, Mot de Passe) au-dessus du bouton sÕinscrire\n" +
            "et valider.</span><span style='mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>ATTENTION</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;: pour lÕinstant les infos sont en http et non https (donc mot de\n" +
            "passe en clair sur le web, ne pas en utiliser un trop personnel&nbsp;!)</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Pour sÕenregistrer&nbsp;(fois suivantes) :</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>Renseigner</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'> les 2 champs (Pseudo, Mot de passe) au-dessus du bouton\n" +
            "s&nbsp;Ôenregistrer et valider.</span><span style='mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>-</span><span style='font-size:7.0pt;font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>2\u008Fme Žtape, vŽrifier les prŽfŽrences&nbsp;:</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Aller dans le menu (3 points en haut ˆ droite)</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>SŽlectionner ÔPrŽfŽrencesÕ</span><span style='mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>VŽrifier</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'> que Ôacc\u008Fs externeÕ est sŽlectionnŽ</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>VŽrifier</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'> que le Pseudo et lÕadresse mail sont valide</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>Modifier</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'> en fonction des besoins le taux de qualitŽ de lÕimage (permet dÕajuster la\n" +
            "taille de lÕimage qui sera transmise sur le rŽseau) entre 1 et 100 %</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>-</span><span style='font-size:7.0pt;font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Menu A propos&nbsp;: (cette page)</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal><span style='font-size:11.0pt;mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>-</span><span style='font-size:7.0pt;font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Envoyer des photos&nbsp;:</span><span style='mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>SŽlectionner Photo (seule option disponible actuellement)</span><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Cliquer sur ÔdŽbuter enregistrementÕ</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:72.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:\"Courier New\";color:black;\n" +
            "mso-fareast-language:FR'>o</span></span><span style='font-size:7.0pt;\n" +
            "font-family:\"Times New Roman\";color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Nouvelle activitŽ&nbsp;:</span><span style='mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>A</span></span><span style='font-size:\n" +
            "11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'> chaque appui sur le\n" +
            "bouton ÇÕprendre la photoÕ</span><span style='mso-ascii-font-family:Calibri;\n" +
            "mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>Une</span></span><span style='font-size:\n" +
            "11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'> photo est prise et\n" +
            "envoyŽe au serveur qui lÕenvoie alors par mail ˆ lÕadresse spŽcifiŽe lors de\n" +
            "lÕenregistrement.</span><span style='mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "class=GramE><span style='font-size:11.0pt;font-family:Wingdings;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'>¤</span><span\n" +
            "style='font-size:7.0pt;font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>&nbsp;&nbsp;</span><span style='font-size:11.0pt;mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>PrŽvoir</span></span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'> un petit dŽlai pour la rŽception.<o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:108.0pt;text-indent:-18.0pt'><span\n" +
            "style='mso-ascii-font-family:Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\n" +
            "\"Times New Roman\";color:black;mso-fareast-language:FR'><o:p>&nbsp;</o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>-</span><span style='font-size:7.0pt;font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Envoyer des VidŽo : (pas encore implŽmentŽ)</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal><o:p>&nbsp;</o:p></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>-</span><span style='font-size:7.0pt;font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
            "style='font-size:11.0pt;mso-ascii-font-family:Calibri;mso-hansi-font-family:\n" +
            "Calibri;mso-bidi-font-family:\"Times New Roman\";color:black;mso-fareast-language:\n" +
            "FR'>Envoyer de lÕaudio : (pas encore implŽmentŽ)</span><span style='mso-ascii-font-family:\n" +
            "Calibri;mso-hansi-font-family:Calibri;mso-bidi-font-family:\"Times New Roman\";\n" +
            "color:black;mso-fareast-language:FR'><o:p></o:p></span></p>\n" +
            "\n" +
            "<p class=MsoNormal><o:p>&nbsp;</o:p></p>\n" +
            "\n" +
            "<p class=MsoNormal style='margin-left:36.0pt;text-indent:-18.0pt'><o:p>&nbsp;</o:p></p>\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "\n" +
            "</html>\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView aboutText = findViewById(R.id.aboutText);
        aboutText.setText(Html.fromHtml(aboutHtml));

    }

}
